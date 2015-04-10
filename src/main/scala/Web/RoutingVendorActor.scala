/**
 * Created by nikolatonkev on 15-04-08.
 */

package Web

import Services.TestService
import akka.actor.{ActorRef, Props, Actor, ActorLogging}
import akka.io.IO
import com.gettyimages.spray.swagger.SwaggerHttpService
import com.wordnik.swagger.model.ApiInfo
import spray.can.Http
import spray.routing.{HttpServiceActor}
import scala.reflect.runtime.universe._
import com.wordnik.swagger.model.ApiInfo

class RoutingVendorActor extends HttpServiceActor {

  override def actorRefFactory = context

  val tests = new TestService {
    def actorRefFactory = context
  }

  /* swaggerService.routes ~ */
  def receive = runRoute(tests.routes ~ swaggerService.routes ~
    get {
      pathPrefix("") { pathEndOrSingleSlash {
        getFromResource("swagger-ui/index.html")
      }
      } ~
        getFromResourceDirectory("swagger-ui")
    })



  val swaggerService = new SwaggerHttpService {
    override def apiTypes = Seq(typeOf[TestService])
    override def apiVersion = "2.0"
    override def baseUrl = "http://localhost:8080"
    override def docsPath = "api-docs"
    override def actorRefFactory = context
    override def apiInfo = Some(new ApiInfo("Nous Dynamics Data Composer API", "A sample service using spray and spray-swagger.", "TOC Url", "nikola_tonkev@yahoo.com", "Apache V2", "http://www.apache.org/licenses/LICENSE-2.0"))
    //authorizations, not used for now :)
  }



}
