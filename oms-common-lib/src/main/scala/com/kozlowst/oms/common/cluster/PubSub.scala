package com.kozlowst.oms.common.cluster

import java.util.UUID

import akka.actor.{Actor, ActorLogging, ActorRef, Terminated}
import akka.cluster.pubsub.DistributedPubSubMediator.Publish
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.{Command, CommandRequest, CommandResponse}

/**
  * Created by tomek on 4/11/17.
  */

trait PubSub[T] extends Actor with ActorLogging {

  def topic: String

  var workers = Map.empty[String, ActorRef]

  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  log.info("Cluster.PubSub SUBSCRIBE for topic: {}", topic)
  mediator ! Subscribe(topic, self)

  override def receive: Receive = {

    case command: Command[T] => {
      val reqUUID = UUID.randomUUID().toString
      saveWorker(reqUUID, sender())
      log.info("PubSub Received {}", command)
      mediator ! Publish(command.topic, CommandRequest(reqUUID, command))
      context.become(waitForResponse(reqUUID))
    }

    case SubscribeAck(Subscribe(topicPubSub, None, self)) =>
      log.info("Cluster.PubSub Subscription ACK(topic: {})", topicPubSub)

    case Terminated(actor) =>
      workers = workers.filterNot(_ == actor)
  }

  def waitForResponse(reqUUID: String): Receive = {
    case CommandResponse(id, `reqUUID`, command: Command[T]) => {
      log.info("Cluster.PubSub Response for Request({}) received.", reqUUID)
      handleResponse(reqUUID, command)
      val worker = workers.get(reqUUID)
      if (worker.isDefined) {
        log.info("Cluster.PubSub -- send response back to worker {}", command.obj)
        worker.get ! command
      } else {
        log.error("No worker for REQ.uuid({})", reqUUID)
      }
    }
  }

  def saveWorker(reqId: String, actor: ActorRef) = {
    if(!workers.contains(reqId)) {
      context.watch(actor)
      workers + (reqId -> actor)
    }
  }

  def handleResponse(reqId: String, command: Command[T])

}
