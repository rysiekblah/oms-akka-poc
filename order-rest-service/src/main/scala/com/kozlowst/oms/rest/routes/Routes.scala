package com.kozlowst.oms.rest.routes

import akka.http.scaladsl.server.Directives._

/**
  * Created by tomek on 4/9/17.
  */
trait Routes extends InstrumentRoute with OrderRoute {
  val routes =
    pathPrefix("oms-service"/"v1") {
      orderRoute ~
      instrumentRoute
    }
}
