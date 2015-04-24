package Services

import akka.actor.{Actor}
import spray.routing.RequestContext

/**
 * Created by nikolatonkev on 15-04-22.
 */
class ServiceOne extends Actor{
  override def receive = {
    case ctx: RequestContext => ctx.complete("A taka")
  }
}
