name := """japanese-tokenizer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
    "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0",
    "com.atilika.kuromoji" % "kuromoji-jumandic" % "0.9.0",
    "com.atilika.kuromoji" % "kuromoji" % "0.9.0",
    "com.ibm.icu" % "icu4j" % "60.1",
    "org.apache.commons" % "commons-lang3" % "3.1",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
