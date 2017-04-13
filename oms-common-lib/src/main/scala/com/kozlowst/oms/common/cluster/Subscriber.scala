package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.Command

/**
  * Created by tomek on 4/10/17.
  */
trait Subscriber[T] extends Actor with ActorLogging {

  def topic: String

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  mediator ! Subscribe(topic, self)

  def handle(obj: T)

  override def receive: Receive = {
    case Command(topic, obj:T) => handle(obj)
    case SubscribeAck(Subscribe(topic, None, self)) =>
      log.info("Cluster.Subscriber Subscription ACK(topic: {})", topic)
  }
}
