package utils

import models.ItemsWPrice
import org.scalatestplus.play.PlaySpec

/**
  * Created by eshan.tandon on 2/20/18.
  */
class OrderHelperSpec extends PlaySpec {

  "totalPrice" should {

    "return total price 0 when list is empty" in {
      OrderHelper.totalPrice(Nil) mustBe 0.0
    }
    "return total price 0 when quantity is 0" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id",0.0,Some(10.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 0.0
    }
    "return total price 0 when price is 0" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id",100.0,Some(0.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 0.0
    }
    "return correct price when 1 item in list" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id",100.0,Some(1.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 100.0
    }
    "return correct price when multiple items in list" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id-1",100.0,Some(1.0)),ItemsWPrice("fake-id-2",10.0,Some(1.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 110.0
    }
    "return correct price when multiple items in list when quantity for one of the items 0" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id-1",100.0,Some(1.0)),ItemsWPrice("fake-id-2",10.0,Some(0.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 100.0
    }
    "return correct price when multiple items in list with price for one of the items 0" in {
      val fakeProductist = List[ItemsWPrice](ItemsWPrice("fake-id-1",100.0,Some(1.0)),ItemsWPrice("fake-id-2",0.0,Some(10.0)))
      OrderHelper.totalPrice(fakeProductist) mustBe 100.0
    }
  }
}
