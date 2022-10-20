lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "com.example",
      scalaVersion := "2.13.6"
    )
  ),
  name := "hello-indigo"
)

lazy val mygame =
  (project in file("."))
    .enablePlugins(
      ScalaJSPlugin,
      SbtIndigo
    ) // Enable the Scala.js and Indigo plugins
    .settings( // Standard SBT settings
      name := "mygame",
      version := "0.0.1",
      scalaVersion := "3.2.0",
      organization := "org.mygame"
    )
    .settings( // Indigo specific settings
      showCursor := true,
      title := "My Game",
      gameAssetsDirectory := "assets",
      windowStartWidth := 720, // Width of Electron window, used with `indigoRun`.
      windowStartHeight := 480, // Height of Electron window, used with `indigoRun`.
      libraryDependencies ++= Seq(
        "io.indigoengine" %%% "indigo" % "0.14.0",
        "io.indigoengine" %%% "indigo-extras" % "0.14.0",
        "io.indigoengine" %%% "indigo-json-circe" % "0.14.0"
      )
    )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
