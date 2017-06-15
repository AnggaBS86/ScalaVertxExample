package com.ab.verticle

import com.ab.config.AppConfig
import com.ab.controller.Controller
import io.vertx.core.{AbstractVerticle, Future}
import io.vertx.ext.web.Router

/**
  * [Documentation Here]
  *
  * @author Angga Bayu S
  */
class HttpVerticle extends AbstractVerticle {

  val router = Router.router(vertx)

  override def start(startFuture: Future[Void]): Unit = {

    router route "/home" handler { routingContext =>
      new Controller(routingContext) handlerHome routingContext
    }

    vertx.createHttpServer().requestHandler(router.accept _).listen(AppConfig.APP_PORT, result => {
      if (result.succeeded())
        startFuture.complete()
      else startFuture.fail(result.cause())
    })
  }
}
