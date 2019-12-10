import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Launcher.executeCommand
import io.vertx.core.Vertx
import mariola.com.vertxStarter.verticles.ApiVerticle
import mariola.com.vertxStarter.verticles.ServerVerticle

class MainVerticle : AbstractVerticle() {

  override fun start(startFuture: Future<Void>?) {
    val vertx = Vertx.vertx()

    vertx.deployVerticle(ServerVerticle::class.java.name)
    vertx.deployVerticle(ApiVerticle::class.java.name)
  }

}

fun main() { executeCommand("run",MainVerticle::class.java.name)}
