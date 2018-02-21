name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test
libraryDependencies +="org.scalamock" %% "scalamock-specs2-support" % "3.6.0" % Test
libraryDependencies += "jp.co.bizreach" %% "aws-dynamodb-scala" % "0.0.6"

