package services

import com.google.inject.ImplementedBy
import models.{OrderRequest, Orders}
import awscala.dynamodbv2.DynamoDB
import com.amazonaws.regions.Regions

/**
  * Created by eshan.tandon on 2/20/18.
  */
@ImplementedBy(classOf[CrudApiImpl])
trait CrudApi {
  def postOrder(order: OrderRequest)

}

class CrudApiImpl extends CrudApi {
  implicit val region = awscala.Region.US_EAST_1
  implicit val db = DynamoDB.apply(accessKeyId = "xxx", secretAccessKey = "xxx")

  def postOrder(order : OrderRequest) = {
    //Insert to Dynamo Database
    Orders.put(order)
  }
}
