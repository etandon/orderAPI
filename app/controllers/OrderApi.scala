package controllers

import javax.inject.Inject

import models.{ErrorResponse, Order, OrderResponse}
import play.api.Logger
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{Action, Controller}
import services.OrderService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by eshan.tandon on 2/19/18.
  */
class OrderApi @Inject()(orderService: OrderService) extends Controller {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def placeOrder = Action.async { implicit request =>
    request.body.asJson.map(_.validate[Order]) match {
      case Some(JsSuccess(order,_)) =>
        orderService.placeOrder(order) map {
          case Right(a) => Ok(Json.toJson(OrderResponse(a)))
          case Left(err) => BadRequest(Json.toJson(ErrorResponse(err)))
        }
      case Some(JsError(err)) =>
        Logger.error(s"[OrderAPI] - Got errors parsing request body")
        Future.successful(BadRequest(Json.toJson(ErrorResponse(err.toString))))
      case None =>
        Logger.error("[OrderAPI] - Could not validate / get JSON body")
        Future.successful(BadRequest(Json.toJson(ErrorResponse("Bad Request"))))
    }
  }

}
