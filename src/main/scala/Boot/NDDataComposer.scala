package Boot

/**
 * Created by nikolatonkev on 15-04-03.
 */

import Web.RoutingVendorActor
import akka.actor.ActorDSL._
import akka.pattern.ask
import akka.actor._
import akka.io.IO
import akka.util.Timeout
import scala.concurrent.duration._
import spray.can.Http

object NDDataComposer extends App {

  implicit val system = ActorSystem() //"nous-dynamics-data-composer-system"

  val service = system.actorOf(Props[RoutingVendorActor]) //"nous-dynamics-data-composer-service"

//  val ioListener = actor("ioListener")(new Act with ActorLogging {
//    become {
//      case b @ Bound(connection) => log.info(b.toString)
//    }
//  })

  implicit val timeout = Timeout(15.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
  //IO(Http).tell(Http.Bind(service, interface = "localhost", port = 8080), ioListener)

}
