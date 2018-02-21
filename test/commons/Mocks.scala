package commons

import services.ProductApi
import org.scalamock.specs2.IsolatedMockFactory


/**
  * Created by eshan.tandon on 2/20/18.
  */

trait Mocks {
  self: IsolatedMockFactory =>
  {
    lazy val mockProductApi = mock[ProductApi]

  }
}
