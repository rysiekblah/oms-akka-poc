name := "order-bot"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.17"
  )
}
    