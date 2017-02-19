val jsOrg     = "my.will.be.done.js"
val facadeOrg = jsOrg ++ ".facade"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.1",
  licenses += ("GPL", url("https://www.gnu.org/licenses/gpl.txt")),
  version := "0.0.1",
  scalacOptions ++= Seq("-deprecation", "-feature"),
  version in webpack := "2.2.1"
)

lazy val commonFacadeSettings = {
  commonSettings ++ Seq(
    organization := facadeOrg
  )
}
lazy val commonJsSettings = {
  commonSettings ++ Seq(
    organization := jsOrg
  )
}

lazy val filesaver = project
  .settings(commonFacadeSettings: _*)
  .settings(
    npmDependencies in Compile ++= Seq(
      "file-saver" → "1.3.3"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val stemmer = project
  .settings(commonFacadeSettings: _*)
  .settings(
    npmDependencies in Compile ++= Seq(
      "stemmer" → "1.0.0"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val stopwords = project
  .settings(commonFacadeSettings: _*)
  .settings(
    npmDependencies in Compile ++= Seq(
      "stopwords-json" → "1.1.0"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val nodesaver = project
  .settings(commonJsSettings: _*)
  .settings(
    libraryDependencies ++= {
      Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.1"
      )
    }
  )
  .dependsOn(filesaver)
  .enablePlugins(ScalaJSBundlerPlugin)
