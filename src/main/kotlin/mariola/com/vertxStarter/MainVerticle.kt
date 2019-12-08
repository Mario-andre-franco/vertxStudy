package mariola.com.vertxStarter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import mariola.com.vertxStarter.model.ResponseJokeApi

fun main(args: Array<String>) {

  val vertx = Vertx.vertx()
  val httpServer = vertx.createHttpServer()

  val router = Router.router(vertx)

  router.get("/icanhazdadjoke.com/j/:id")
    .handler { rountingContext ->
      val request = rountingContext.request()
      request.getParam("id")

      val response = rountingContext.response()
      response.putHeader("content-type","text/json")
        .setChunked(true)
        .write(Json.encodePrettily(ResponseJokeApi("R7UfaahVfFd","My dog used to chase people on a bike a lot. It got so bad I had to take his bike away.","200")))
        .end()
    }
  httpServer
    .requestHandler(router::accept)
    .listen(8080)

}
