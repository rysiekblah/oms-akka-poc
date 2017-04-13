package com.kozlowst.oms.common.cluster

import akka.actor.{Actor, ActorLogging}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.kozlowst.oms.common.commands.{Command, CommandSync}

/**
  * Created by tomek on 4/10/17.
  */
trait Publisher[T] extends Actor with ActorLogging {

  import DistributedPubSubMediator.Publish
  val mediator = DistributedPubSub(context.system).mediator

  override def receive: Receive = {
    case command: Command[T] =>
      log.info("Cluster.Publisher {}", command)
      mediator ! Publish(command.topic, command.obj)

    case command: CommandSync[T] =>
      log.info("Cluster.Publisher {}", command)
      context.become(handleSync(command))
  }

  def handleSync(commandSync: CommandSync[T]): Receive
}
