scalaVersion := "3.2.0"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-ember-server" % "1.0.0-M37",
  "org.http4s" %% "http4s-ember-client" % "1.0.0-M37",
  "org.scalactic" %% "scalactic" % "3.2.15",
  "org.scalatest" %% "scalatest" % "3.2.15" % "test",
  "org.http4s" %% "http4s-dsl" % http4sVersion
)
