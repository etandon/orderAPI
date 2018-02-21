package commons

import play.api.libs.ws.{WSRequest, WSResponse}

/**
  * Created by eshan.tandon on 2/19/18.
  */

/**
  * Typeclass that handles Web Service response. Should return either a sequence of Errors or
  * some response type.
  *
  * @tparam E
  * @tparam B
  */
trait ResponseHandler[E,B] {
  self =>

  def apply(requestId: Option[String], request: WSRequest)(response: WSResponse): Either[E,B]

  def withTransformation[U](f: B => U): ResponseHandler[E,U] = new ResponseHandler[E,U] {
    override def apply(requestId: Option[String], request: WSRequest)(response: WSResponse): Either[E, U] = self.apply(requestId, request)(response) match {
      case Left(errors) => Left(errors)
      case Right(r) => Right(f(r))
    }
  }
}