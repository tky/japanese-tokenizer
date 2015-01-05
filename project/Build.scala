import sbt._
import Keys._

object TranslatorBuild extends Build {

  lazy val _version = "0.0.1"

/*
  lazy val root = Project(
    id = "root",
    base = file(".")
  ).aggregate(translator)
  */

  val baseDependency = Seq(
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
    "org.atilika.kuromoji" % "kuromoji" % "0.7.7",
    "com.ibm.icu" % "icu4j" % "54.1.1",
    "org.apache.commons" % "commons-lang3" % "3.1"
  )

  lazy val main = Project (
    id = "translator",
    base = file ("."),
    settings = Defaults.defaultSettings ++ Seq (
      name := "translator",
      organization := "com.github.tky",
      version := _version,
      scalaVersion := "2.10.2",
      resolvers ++= Seq(
        "ATILIKA dependencies" at "http://www.atilika.org/nexus/content/repositories/atilika"
      ),
      libraryDependencies ++= baseDependency,
      scalacOptions ++= Seq("-deprecation", "-language:_")
    )
  )
}
