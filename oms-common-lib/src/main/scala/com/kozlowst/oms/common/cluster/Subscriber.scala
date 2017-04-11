package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.Command

/**
  * Created by tomek on 4/10/17.
  */
abstract class Subscriber[T](topic: String) extends Actor with ActorLogging {

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  mediator ! Subscribe(topic, self)

  def handle(obj: T)

  override def receive: Receive = {
    case Command(subTopic, obj: T) => handle(obj)
    case SubscribeAck(Subscribe(subTopic, None, self)) =>
      log.info("Cluster.Subscriber Subscription ACK(topic: {})", subTopic)
  }
}
