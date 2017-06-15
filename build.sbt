name := "ScalaIntellijExample"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "io.vertx" % "vertx-platform" % "2.1.2",
  "io.vertx" % "vertx-web" % "3.4.1",
  "io.vertx" % "vertx-core" % "3.4.1",
  "io.vertx" % "lang-scala" % "0.3.0",
  "io.vertx" % "vertx-hazelcast" % "3.3.3",
  "org.apache.logging.log4j" % "log4j-core" % "2.8.2"
)