/**
 * Created by nikolatonkev on 15-04-08.
 */

package Web

import Services.{TestServiceTwoHttp, TestServiceOneHttp}

import akka.actor.ActorLogging
import spray.routing._
import scala.reflect.runtime.universe._
import com.wordnik.swagger.model.ApiInfo
import com.gettyimages.spray.swagger.SwaggerHttpService



class RoutingVendorActor extends HttpServiceActor with SwaggerService with ActorLogging {

  override def actorRefFactory = context

  val swaggerService = new SwaggerHttpService {
    override def apiTypes = Seq(typeOf[TestServiceOneHttp], typeOf[TestServiceTwoHttp])
    override def apiVersion = "2.0"
    override def baseUrl = "/"
    override def docsPath = "api-docs"
    override def actorRefFactory = context
    override def apiInfo = Some(new ApiInfo("Nous Dynamics Data Composer API", "A sample service using spray and spray-swagger.", "TOC Url", "nikola_tonkev@yahoo.com", "Apache V2", "http://www.apache.org/licenses/LICENSE-2.0"))
    //authorizations, not used for now :)
  }


  val testOne = new TestServiceOneHttp {
    def actorRefFactory = context
  }

  val testTwo = new TestServiceTwoHttp {
    def actorRefFactory = context
  }

  def receive = runRoute(testOne.routes ~ testTwo.routes ~ swaggerService.routes ~ swagger)

}
