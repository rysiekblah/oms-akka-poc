package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.DistributedPubSubMediator.Publish
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.{Command, CommandRequest, CommandResponse}
import com.kozlowst.oms.common.utils.CommandUtils

/**
  * Created by tomek on 4/11/17.
  */

abstract class PubSub(topic: String) extends Actor with ActorLogging {

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  mediator ! Subscribe(topic, self)

  override def receive: Receive = {
    case command: Command => {
      val reqId = CommandUtils.sequenceNumber
      mediator ! Publish(topic, CommandRequest(reqId, command))
      context.become(waitForResponse(reqId))
    }
    case SubscribeAck(Subscribe(subTopic, None, self)) =>
      log.info("Cluster.Subscriber Subscription ACK(topic: {})", subTopic)
  }

  def waitForResponse(reqId: Long): Receive = {
    case CommandResponse(id, `reqId`, command) => {
      handleResponse(reqId, command)
      context.stop(self)
    }
  }

  def handleResponse(reqId: Long, command: Command)

}
