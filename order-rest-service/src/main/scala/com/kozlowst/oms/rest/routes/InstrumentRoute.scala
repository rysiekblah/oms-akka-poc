package com.kozlowst.oms.rest.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._

/**
  * Created by tomek on 4/9/17.
  */

trait InstrumentRoute {
  val instrumentRoute =
    (path("instrument"/"last-update") & get) {
      complete(StatusCodes.OK)
    }
}
