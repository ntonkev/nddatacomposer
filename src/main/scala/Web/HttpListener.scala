package Web

import Services.TestService
import akka.actor.{Actor, ActorRef, Props}
import spray.routing.{HttpService}

/**
 * Created by nikolatonkev on 15-04-09.
 */
class HttpListener extends Actor with HttpService {

    override def actorRefFactory = context

    val tests = new TestService {
      def actorRefFactory = context
    }


  def receive = runRoute(tests.routes)

}
