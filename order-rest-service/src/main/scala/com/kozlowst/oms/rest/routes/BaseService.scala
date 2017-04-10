package com.kozlowst.oms.rest.routes

import akka.actor.ActorRef
import com.kozlowst.oms.rest.ServiceConfig

/**
  * Created by tomek on 4/10/17.
  */
trait BaseService extends ServiceConfig {
  var publisher:ActorRef = _
}
