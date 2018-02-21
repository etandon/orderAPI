import scala.concurrent.Future
import scala.util.Either

/**
  * Created by eshan.tandon on 2/19/18.
  */
package object services {

  case class ServiceError(code: String, message: String, details: String)

  type ServiceResponse[Resp] = Future[Either[Seq[ServiceError], Resp]]

}
