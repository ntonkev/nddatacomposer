/**
 * Created by nikolatonkev on 15-04-08.
 */

package Web

import Services.TestServiceOne
//import akka.actor.{ActorRef, Props, Actor, ActorLogging}
//import akka.io.IO
//import com.gettyimages.spray.swagger.SwaggerHttpService
//import com.wordnik.swagger.model.ApiInfo
//import spray.can.Http
//import spray.routing.{HttpServiceActor}
//import scala.reflect.runtime.universe._
//import com.wordnik.swagger.model.ApiInfo

import akka.actor.ActorLogging
import spray.routing._
import com.gettyimages.spray.swagger._
import scala.reflect.runtime.universe._
import com.wordnik.swagger.model.ApiInfo
import com.wordnik.swagger.annotations.Api
import scala.reflect.runtime.universe
import spray.routing.Directive.pimpApply
import com.wordnik.swagger.model.ApiInfo
import com.gettyimages.spray.swagger.SwaggerHttpService



class RoutingVendorActor extends HttpServiceActor with SwaggerService with ActorLogging {

  override def actorRefFactory = context

  val swaggerService = new SwaggerHttpService {
    override def apiTypes = Seq(typeOf[TestServiceOne])
    override def apiVersion = "2.0"
    override def baseUrl = "/"
    override def docsPath = "api-docs"
    override def actorRefFactory = context
    override def apiInfo = Some(new ApiInfo("Nous Dynamics Data Composer API", "A sample service using spray and spray-swagger.", "TOC Url", "nikola_tonkev@yahoo.com", "Apache V2", "http://www.apache.org/licenses/LICENSE-2.0"))
    //authorizations, not used for now :)
  }


  val testOne = new TestServiceOne {
    def actorRefFactory = context
  }

  def receive = runRoute(testOne.routes ~ swaggerService.routes ~ swagger)

}
