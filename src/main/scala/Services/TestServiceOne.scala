package Services

import com.wordnik.swagger.annotations.{ApiResponses, ApiResponse, ApiOperation, Api}
import spray.routing.{HttpService}


/**
 * Created by nikolatonkev on 15-04-08.
 */

@Api(value = "tests", description = "Tests apis.", position = 1)
trait TestServiceOne extends HttpService{

  //import Json4sSupport._

  val routes = tests

  @ApiOperation(value = "Get a greating", notes = "", response=classOf[String], nickname = "", httpMethod = "GET")
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Get a greating successful executed"),
    new ApiResponse(code = 404, message = "Greating not found"),
    new ApiResponse(code = 400, message = "Invalid greating request")
  ))
  def tests = pathPrefix("tests"){
      pathEndOrSingleSlash{
        complete("tests")
      } ~
      path("one") {
        get {
          complete("hello TestServiceOne")
        }
      }
  }

  /*/
  val routes = tests

  @ApiOperation(value = "Main route", notes = "", response=classOf[String], nickname = "tests", httpMethod = "GET")
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Get a greating successful executed"),
    new ApiResponse(code = 404, message = "Greating not found"),
    new ApiResponse(code = 400, message = "Invalid greating request")
  ))
  def tests = path("tests"){
    get {
      complete("tests response")
    }
  }

  def one = path("tests"){
    path("one"){
      get {
        complete("one response")
      }
    }
  }
  */


}
