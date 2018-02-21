package services

import javax.inject.Inject

import com.google.inject.ImplementedBy
import models.{ItemsWPrice, Order, OrderRequest}
import play.api.Logger
import play.api.libs.json.JsValue
import utils.OrderHelper
import java.util.UUID.randomUUID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by eshan.tandon on 2/19/18.
  */

@ImplementedBy(classOf[OrderServiceImpl])
trait OrderService {
  def placeOrder(order: Order):Future[Either[String,Double]]
}

class OrderServiceImpl @Inject()(implicit productClient:ProductApi,crudClient:CrudApi)
  extends OrderService
     {
  def placeOrder(order: Order):Future[Either[String,Double]] = {
    import scala.concurrent.duration._
    val productList =for{
      item <- order.items
    } yield {
      val price: Option[Double] =
        try {
        Some(Await.result(productClient.getProductDetails(item.productId), Duration(10000, MILLISECONDS)).toDouble)
        } catch
          {
            case e:Exception => None
          }
      ItemsWPrice(item.productId, item.quantity, price)
    }


    productList match {
      case list if(list.exists(a => a.price == None)) => Future.successful(Left("Product Not found"))
      case list =>
        val total = OrderHelper.totalPrice(list)
        val orderInsert= OrderRequest(randomUUID().toString,order.customerId,list,total)
        crudClient.postOrder(orderInsert)
        Logger.debug(s"Order: $orderInsert")
        Future.successful (Right(total))
    }
  }
}
