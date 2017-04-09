package com.kozlowst.oms.rest

import akka.cluster.Cluster
import akka.actor.{ActorSystem, Address, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.kozlowst.oms.common.{Order, Side}
import spray.json.DefaultJsonProtocol._

/**
  * Created by tomek on 4/7/17.
  */

case class OrderRequest(accountName: String, comment: String, createdBy: String, instrumentId: Long,
                        size: Long, side: Int, autoStop: Int)

object OmsRestServiceApplication extends App with ServiceConfig {

  implicit val system = ActorSystem(actorSystemName)
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  implicit val orderFormat = jsonFormat7(OrderRequest)

  val addr = Cluster(system).selfAddress
  println("Join address: " + addr)
  println("Common join-addr: " + Address(addressProtocol, actorSystemName, addressHost, addressPort))
  Cluster(system).join(addr)

  val publisher = system.actorOf(Props[Publisher], "publisher")

  system.actorOf(Props[ClusterListener], "clusterListener")

  val routes =
    pathPrefix("oms-service") {
      path("hello") {
        get {
          println("Hello called")
          publisher ! "OMS-SYSTEM-PING"
          complete((StatusCodes.OK, "hello published"))
        }
      } ~
      pathPrefix("order") {
        post {
          entity(as[OrderRequest]) { order =>
            println("Order Request: " + order)
            val o = Order.createMarketOrd(order.accountName, order.comment, order.createdBy,
              order.instrumentId, order.size, Side(order.side), order.autoStop)
            publisher ! o
            complete((StatusCodes.OK, "order created"))
          }
        } ~
        put {
          complete((StatusCodes.OK, "order updated"))
        }
      }
    }

  Http().bindAndHandle(routes, restSvcHost, restSvcPort)

}
