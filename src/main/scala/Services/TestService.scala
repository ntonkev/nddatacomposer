package Services

import com.wordnik.swagger.annotations.{ApiOperation, Api}
import spray.routing.{HttpService}


/**
 * Created by nikolatonkev on 15-04-08.
 */

@Api(value = "/tests", description = "Tests apis.", position = 0)
trait TestService extends HttpService{

  val routes = helloRoute

  @ApiOperation(value = "Get a greating", notes = "", response=classOf[String], nickname = "hello", httpMethod = "GET")
  def helloRoute = get {
    path("hello") {
      complete("hello swagger")
    }
  }

}
