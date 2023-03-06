scalaVersion := "3.2.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.15"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"

lazy val mygame =
  (project in file("."))
    .enablePlugins(
      ScalaJSPlugin,
      SbtIndigo
    )
    .settings(
      name := "mygame",
      version := "0.0.1",
      scalaVersion := "3.2.0",
      organization := "org.mygame"
    )
    .settings(
      showCursor := true,
      title := "My Game",
      gameAssetsDirectory := "assets",
      windowStartWidth := 400,
      windowStartHeight := 600,
      libraryDependencies ++= Seq(
        "io.indigoengine" %%% "indigo" % "0.14.0",
        "io.indigoengine" %%% "indigo-extras" % "0.14.0",
        "io.indigoengine" %%% "indigo-json-circe" % "0.14.0"
      )
    )

addCommandAlias("buildGame", ";~compile;fastOptJS;indigoBuild")
addCommandAlias("runGame", ";compile;fastOptJS;indigoRun")
addCommandAlias("buildGameFull", ";~compile;fullOptJS;indigoBuildFull")
addCommandAlias("runGameFull", ";compile;fullOptJS;indigoRunFull")
