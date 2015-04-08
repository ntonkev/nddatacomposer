/**
 * Created by nikolatonkev on 15-04-03.
 */
import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object NDDataComposer extends App with SimpleRoutingApp {
  implicit val actorSystem = ActorSystem()

  startServer(interface = "localhost", port=8080){
    get {
      path("hello"){
        complete{
          "Hello world!"
        }
      }
    }
  }
}
