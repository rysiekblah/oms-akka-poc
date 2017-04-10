package com.kozlowst.oms.dumper

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.{CommonConfig, Order}

/**
  * Created by tomek on 4/8/17.
  */
class Subscriber extends Actor with ActorLogging with CommonConfig {

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }

  val mediator = DistributedPubSub(context.system).mediator

  mediator ! Subscribe(topicOms, self)

  override def receive: Receive = {
    case order: Order => {
      log.info("Order received: {}", order)
    }
    case s: String => {
      log.info("Got STRING {}", s)
    }
    case SubscribeAck(Subscribe(topic, None, self)) => {
      log.info("Subscription ACK for {}", topic)
    }
  }
}
