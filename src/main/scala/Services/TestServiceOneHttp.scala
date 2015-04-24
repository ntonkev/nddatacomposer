package Services

import akka.actor.{ActorSystem, Props}
import com.wordnik.swagger.annotations._
import spray.routing.{HttpService}


/**
 * Created by nikolatonkev on 15-04-08.
 */

@Api(value = "tsone", description = "Tests API with simple routing.", position = 1)
trait TestServiceOneHttp extends HttpService{

  //import Json4sSupport._
  implicit val actorSystem = ActorSystem()
  import actorSystem.dispatcher

  val routes = tsone

  lazy val service = actorSystem.actorOf(Props(new ServiceOne))

  @ApiOperation(value = "Main route entry point", notes = "", produces = "text/plain; charset=UTF-8", response=classOf[String], nickname = "", httpMethod = "GET")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "Id", value = "Id request", required = true, dataType = "NDApiRequest", paramType = "NDApiRequest[String]")
  ))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Main route entry point successful executed"),
    new ApiResponse(code = 404, message = "Main route entry point not found"),
    new ApiResponse(code = 400, message = "Invalid main route entry point request")
  ))
  def tsone = path("tsone") {
    get {
      ctx => service ! ctx
      //complete("TestServiceOne main route entry point!")
    }
  }


}
