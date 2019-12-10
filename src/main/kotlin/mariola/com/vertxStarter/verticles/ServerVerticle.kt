package mariola.com.vertxStarter.verticles

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx


class ServerVerticle : AbstractVerticle() {
  override fun start() {
    val vertx = Vertx.vertx()

    vertx.createHttpServer()
      .listen(8080)
  }
}
