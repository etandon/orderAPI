package models

import jp.co.bizreach.dynamodb4s.{DynamoAttribute, DynamoHashKey, DynamoTable}
import play.api.libs.json._

/**
  * Created by eshan.tandon on 2/19/18.
  */
case class Items(
                  productId: String,
                  quantity: Double
                )

case class ItemsWPrice(
                  productId: String,
                  quantity: Double,
                  price: Option[Double]
                      )

case class Order(
                         customerId: String,
                         items: List[Items]
                       )

object Items {
  implicit val Items = Json.format[Items]
}

object Order {
  implicit val Order = Json.format[Order]
  implicit val Items = Json.format[Items]
}

case class OrderResponse(total: Double)

object OrderResponse {
  implicit val OrderResponse = Json.format[OrderResponse]
}

case class OrderRequest(
                  orderId: String,
                  customerId: String,
                  items: List[ItemsWPrice],
                  totalCost: Double
                )

object OrderRequest {
  implicit val ItemsWPrice = Json.format[ItemsWPrice]
  implicit val OrderRequest = Json.format[OrderRequest]
}

object Orders extends DynamoTable {
  val table      = "Order"
  val orderId    = DynamoHashKey[String]("orderId")
  val customerId = DynamoAttribute[Int]("customerId")
  val items       = DynamoAttribute[String]("items")
  val totalCost  = DynamoAttribute[Double]("totalCost")
}

