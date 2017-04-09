name := "event-dumper-service"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
//    "com.typesafe.akka" %% "akka-cluster" % "2.4.17",
    "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17",
    "joda-time" % "joda-time" % "2.9.9"
  )
}
    