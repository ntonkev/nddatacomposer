package Web

import Services.TestServiceOne
import com.gettyimages.spray.swagger.SwaggerHttpService
import com.wordnik.swagger.model.ApiInfo
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



  path("swagger-ui") {
        getFromResource("swagger-ui/index.html")
      } ~
      getFromResourceDirectory("swagger-ui")

}
