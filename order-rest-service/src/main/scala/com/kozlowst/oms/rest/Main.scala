package com.kozlowst.oms.rest

import akka.cluster.Cluster
import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.kozlowst.oms.rest.routes.Routes

/**
  * Created by tomek on 4/7/17.
  */

object Main extends App with ServiceConfig with Routes {

  implicit val system = ActorSystem(actorSystemName)
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  Cluster(system).join(Cluster(system).selfAddress)

  publisher = system.actorOf(Props[Publisher], "bus-publisher")

  system.actorOf(Props[ClusterListener], "clusterListener")

  Http().bindAndHandle(routes, restSvcHost, restSvcPort)

}
