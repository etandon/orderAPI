package models

import play.api.libs.json.Json

/**
  * Created by eshan.tandon on 2/19/18.
  */
case class Product(
                           Id: String,
                           Category: String,
                           Name: String,
                           Price: Double
                         )

object Product {
  implicit val Product = Json.format[Product]
}
