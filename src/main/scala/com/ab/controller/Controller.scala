package com.ab.controller

import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext

/**
  * [Documentation Here]
  *
  * @author Angga Bayu S
  */
class Controller(routingContext: RoutingContext) {
  def handlerHome(routingContext: RoutingContext): Unit = {
    val response: HttpServerResponse = routingContext.response()
    response.putHeader("content-type", "application/json; charset=utf-8")
      .end(new JsonObject().put("status", "oke").encode())
  }
}
