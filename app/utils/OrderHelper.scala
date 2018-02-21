package utils

import models.ItemsWPrice

/**
  * Created by eshan.tandon on 2/20/18.
  */
object OrderHelper {
  def totalPrice(productList :List[ItemsWPrice],total: Double = 0.0): Double = {
    productList match {
      case Nil => total
      case ItemsWPrice(_,quantity,price) :: rest => totalPrice(rest, total + (price.getOrElse(0.0) * quantity))
    }
  }
}
