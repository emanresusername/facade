val githubUsername = "emanresusername"
val jsOrg          = s"com.github.$githubUsername.js"
val facadeOrg      = jsOrg ++ ".facade"
val githubUrl      = s"https://github.com/$githubUsername/facade"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.1",
  licenses += ("GPL", url("https://www.gnu.org/licenses/gpl.txt")),
  version := "0.0.1",
  scalacOptions ++= Seq("-deprecation", "-feature"),
  version in webpack := "2.2.1",
  homepage := Some(url(Seq(githubUrl, name.value).mkString("/"))),
  description := "a collection of scalajs facades and utilities",
  scmInfo := Some(
    ScmInfo(url(githubUrl),
            s"scm:git:git@github.com:$githubUsername/facade.git")),
  developers := List(
    Developer(githubUsername,
              "jordan gwyn",
              "emailme.jtg+developer@gmail.com",
              url(s"https://github.com/$githubUsername"))
  ),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishMavenStyle := true,
  pomIncludeRepository := { _ =>
    false
  },
  publishArtifact in Test := false
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

lazy val noPublishSettings = Seq(
  publish := (),
  publishLocal := (),
  publishArtifact := false
)

// TODO: ignore root project in publishing/releasing
lazy val root = project
  .in(file("."))
  .settings(organization := s"com.github.$githubUsername")
  .settings(noPublishSettings: _*)
  .aggregate(stemmer, filesaver, nodesaver, stopwords)
