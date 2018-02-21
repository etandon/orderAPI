package services

import javax.inject.Inject

import com.google.inject.ImplementedBy
import commons.ResponseHandler
import models.Product
import play.api.Logger
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by eshan.tandon on 2/19/18.
  */
@ImplementedBy(classOf[ProductApiImpl])
trait ProductApi {
  def getProductDetails(productId: String): Future[String]

}

class ProductApiImpl @Inject()(implicit client: WSClient)
  extends ProductApi {
  private def get[Response](path: String,
                            queryParams: Seq[(String, String)])
   = {
    val url = "https://petstoreapp.azurewebsites.net/api" + path
    val request =
      client
        .url(url)

    request.get()
      //.map(responseHandler(None, request))

  }

  def getProductDetails(productId: String): Future[String] ={
    Logger.debug(s"getProductDetails")
    get[Product](
      s"/products/$productId",
      Seq()
    ).flatMap {
      response =>
        val price = (response.json \ "Price").get
        Logger.debug(s"Response: $price")
        Future.successful(price.toString())
    }
  }

}
