Seq(
  "com.geirsson"   % "sbt-scalafmt"        % "0.5.6",
  "ch.epfl.scala"  % "sbt-scalajs-bundler" % "0.5.0",
  "org.xerial.sbt" % "sbt-sonatype"        % "1.1",
  "com.jsuereth"   % "sbt-pgp"             % "1.0.0"
).map(addSbtPlugin)
