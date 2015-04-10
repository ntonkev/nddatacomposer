/**
 * Created by nikolatonkev on 15-04-03.
 */

import Web.RoutingVendorActor
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http



object NDDataComposer extends App {

  implicit val system = ActorSystem()

  val service = system.actorOf(Props[RoutingVendorActor])

  /*
  val ioListener = actor("ioListener")(new Act {
    become {
      case b @ Bound(connection) => println(b.toString)
    }
  })
  */

  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
