package Services

import com.wordnik.swagger.annotations._
import javax.ws.rs.Path
import spray.routing.HttpService

/**
 * Created by nikolatonkev on 15-04-21.
 */
@Api(value = "/tstwo", description = "Tests API with path prefix.", position = 2)
trait TestServiceTwo extends HttpService {

  val routes = tstwo

  //@Path("/")
  @ApiOperation(value = "Get tstwo main route response", notes = "", produces = "text/plain; charset=UTF-8", response=classOf[String], nickname = "", httpMethod = "GET")
  def singlePath = pathEndOrSingleSlash{
    complete("TestServiceTwo main route entry point")
  }

  @Path("/one")
  @ApiOperation(value = "Get one entry point response", notes = "", produces = "text/plain; charset=UTF-8", response=classOf[String], nickname = "", httpMethod = "GET")
  def two = path("one") {
    get {
      complete("TestServiceTwo /one route entry point")
    }
  }


  def tstwo = pathPrefix("tstwo"){
    singlePath~two
  }

}
