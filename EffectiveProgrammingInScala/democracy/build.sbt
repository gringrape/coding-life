course := "effective-scala"
assignment := "democracy"

scalaVersion := "3.2.0"

libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "0.7.26" % Test
)

Compile / scalacOptions ++= Seq("-deprecation")
