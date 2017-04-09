name := "order-rest-service"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17",
    "joda-time" % "joda-time" % "2.9.9",
    "com.typesafe.akka" %% "akka-http" % "10.0.5",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5"
  )
}
