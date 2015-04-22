package Web

import spray.routing.HttpService

trait SwaggerService extends HttpService {
  val swagger = get {
    pathPrefix("") {
      pathEndOrSingleSlash {
        getFromResource("swagger-ui/index.html")
      }
    } ~
    getFromResourceDirectory("swagger-ui")
  }
}
