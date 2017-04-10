package com.kozlowst.oms.rest.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.kozlowst.oms.common.{Order, Side}
import com.kozlowst.oms.rest.models.OrderRequest
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
//import com.kozlowst.oms.rest.Publisher

/**
  * Created by tomek on 4/9/17.
  */

trait OrderRoute extends DefaultJsonProtocol with BaseService {

  implicit val orderRequestFormat = jsonFormat7(OrderRequest)

  val orderRoute =
    (path("order") & post) {
      entity(as[OrderRequest]) { order =>
        println("Order Request: " + order)
        val o = Order.createMarketOrd(order.accountName, order.comment, order.createdBy,
        order.instrumentId, order.size, Side(order.side), order.autoStop)
        publisher ! o
        complete((StatusCodes.OK, "order created"))
      }
    } ~
      (path("order") & put) {
        complete((StatusCodes.OK, "order updated"))
      }

}
