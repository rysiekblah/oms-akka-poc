name := "oms-common-lib"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17",
    "com.typesafe" % "config" % "1.3.1",
    "joda-time" % "joda-time" % "2.9.9",
    "org.scalatest" %%  "scalatest" % "2.2.5" % "test"
  )
}
    