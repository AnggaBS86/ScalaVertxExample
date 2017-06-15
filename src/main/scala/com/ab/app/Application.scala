package com.ab.app

import com.ab.config.AppConfig
import com.ab.utils.MyLogger
import com.ab.verticle.HttpVerticle
import com.hazelcast.config.Config
import io.vertx.core.{Vertx, VertxOptions}
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager

/**
  * [Documentation Here]
  *
  * @author Angga Bayu S
  */
object Application {

  def applicationBootstrap(): Unit = {
    val hazelcastConfig: Config = new Config()
    val mgr: HazelcastClusterManager = new HazelcastClusterManager(hazelcastConfig)
    val options: VertxOptions = new VertxOptions() setClusterManager mgr

    Vertx.clusteredVertx(options, resultHandler => {
      if (resultHandler.succeeded()) {
        val vertx = resultHandler.result()
        vertx.deployVerticle(new HttpVerticle())
        new MyLogger(this.getClass.getName).info("Httpserver started at port : " + AppConfig.APP_PORT)
      } else {
        new MyLogger(this.getClass.getName).error("Httpserver started failed at port : " + AppConfig.APP_PORT)
      }
    })
  }
}
