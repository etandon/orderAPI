package models

import play.api.libs.json.Json

/**
  * Created by eshan.tandon on 2/19/18.
  */
case class ErrorResponse(error: String)

object ErrorResponse {
  implicit val ErrorResponse = Json.format[ErrorResponse]
}
