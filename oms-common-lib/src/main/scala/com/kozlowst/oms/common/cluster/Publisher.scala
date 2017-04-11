package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.{Command, CommandSync}

/**
  * Created by tomek on 4/10/17.
  */
class Publisher extends Actor with ActorLogging {

  import DistributedPubSubMediator.Publish
  val mediator = DistributedPubSub(context.system).mediator

  override def receive: Receive = {
    case Command(topic, obj) =>
      log.info("Cluster.Publisher COMMAND(topic: {}, obj: {})", topic, obj)
      mediator ! Publish(topic, obj)

    case CommandSync(topic, obj, actorRef) =>
      log.info("Cluster.Publisher COMMAND-SYNC(topic: {}, obj: {})", topic, obj)
  }
}
