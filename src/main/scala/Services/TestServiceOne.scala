package Services

import com.wordnik.swagger.annotations.{ApiResponses, ApiResponse, ApiOperation, Api}
import spray.routing.{HttpService}


/**
 * Created by nikolatonkev on 15-04-08.
 */

@Api(value = "/hello", description = "Tests apis.", position = 0)
trait TestServiceOne extends HttpService{

  //import Json4sSupport._

  val routes = helloRoute

  @ApiOperation(value = "Get a greating", notes = "", response=classOf[String], nickname = "hello", httpMethod = "GET")
  //@ApiOperation(value = "Get a greating", notes = "", nickname = "hello", httpMethod = "GET", produces = "text/plain; charset=UTF-8", response = classOf[String])
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Get a greating successful executed"),
    new ApiResponse(code = 404, message = "Greating not found"),
    new ApiResponse(code = 400, message = "Invalid greating request")
  ))
  def helloRoute = pathPrefix("tests"){
      pathEnd {
        complete("tests")
      } ~
      path("hello") {
        get {
          complete("hello TestServiceOne")
        }
      }
  }

}
