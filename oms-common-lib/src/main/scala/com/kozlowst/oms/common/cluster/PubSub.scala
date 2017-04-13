package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.DistributedPubSubMediator.Publish
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.{Command, CommandRequest, CommandResponse}
import com.kozlowst.oms.common.utils.CommandUtils

/**
  * Created by tomek on 4/11/17.
  */

trait PubSub[T] extends Actor with ActorLogging {

  def topic: String

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  log.info("Cluster.PubSub SUBSCRIBE for topic: {}", topic)
  mediator ! Subscribe(topic, self)

  override def receive: Receive = {
    case command: Command[T] => {
      log.info("PubSub Received {}", command)
      val reqId = CommandUtils.sequenceNumber
      mediator ! Publish(topic, CommandRequest(reqId, command))
      context.become(waitForResponse(reqId))
    }
    case SubscribeAck(Subscribe(topicPubSub, None, self)) =>
      log.info("Cluster.PubSub Subscription ACK(topic: {})", topicPubSub)
  }

  def waitForResponse(reqId: Long): Receive = {
    case CommandResponse(id, `reqId`, command: Command[T]) => {
      log.info("Cluster.PubSub Response for Request({}) received.", reqId)
      handleResponse(reqId, command)
      context.stop(self)
    }
  }

  def handleResponse(reqId: Long, command: Command[T])

}
