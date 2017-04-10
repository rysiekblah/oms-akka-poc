package com.kozlowst.oms.rest

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.{CommonConfig, Order}

/**
  * Created by tomek on 4/8/17.
  */
class Publisher extends Actor with ActorLogging with CommonConfig {

  import DistributedPubSubMediator.Publish

  val mediator = DistributedPubSub(context.system).mediator

  def receive = {
    case order: Order => {
      log.info(">> publishing order {}", order)
      mediator ! Publish(topicOms, order)
    }
    case s: String => {
      log.info(">> Publish STRING {}", s)
      mediator ! Publish(topicOms, s)
    }
  }
}
