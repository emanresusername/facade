scalaVersion in ThisBuild := "2.12.2",

lazy val commonSettings = Seq(
  licenses += ("GPL", url("https://www.gnu.org/licenses/gpl.txt")),
  version := "0.0.3",
  scalacOptions ++= Seq("-deprecation", "-feature", "-Xlint"),
  description := "a collection of scalajs facades and utilities",
  organization := "my.will.be.done"
)

lazy val filesaver = project
  .settings(commonSettings)
  .settings(
    name := "facade-filesaver",
    npmDependencies in Compile ++= Seq(
      "file-saver" → "1.3.3"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val stemmer = project
  .settings(commonSettings)
  .settings(
    name := "facade-stemmer",
    npmDependencies in Compile ++= Seq(
      "stemmer" → "1.0.0"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val stopwords = project
  .settings(commonSettings)
  .settings(
    name := "facade-stopwords",
    npmDependencies in Compile ++= Seq(
      "stopwords-json" → "1.2.0"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val nodesaver = project
  .settings(commonSettings)
  .settings(
    name := "js-nodesaver",
    libraryDependencies ++= {
      Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.2"
      )
    }
  )
  .dependsOn(filesaver)
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val d3cloud = project
  .settings(commonSettings)
  .settings(
    name := "facade-d3-cloud",
    npmDependencies in Compile ++= Seq(
      "d3-cloud" → "1.2.4"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)

lazy val root = project
  .in(file("."))
  .aggregate(stemmer, filesaver, nodesaver, stopwords, d3cloud)
