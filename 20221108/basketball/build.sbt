lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.gringrape",
      scalaVersion := "3.2.0"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % Test
