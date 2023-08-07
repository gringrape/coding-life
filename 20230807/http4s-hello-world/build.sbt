scalaVersion := "3.3.0"

val http4sVersion = "0.23.23"

enablePlugins(
  JavaAppPackaging,
  DockerPlugin
)

Compile / mainClass := Some("Main")
Docker / packageName := "gringrape/http4s-helloworld"

libraryDependencies ++= Seq(
  // HTTP4S
  "org.http4s" %% "http4s-ember-client" % http4sVersion,
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,

  // ScalaTest
  "org.scalatest" %% "scalatest" % "3.2.16" % "test",

  // logger
  "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
)
