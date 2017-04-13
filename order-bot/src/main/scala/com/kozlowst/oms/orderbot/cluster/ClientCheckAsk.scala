package com.kozlowst.oms.orderbot.cluster

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.kozlowst.oms.common.commands.{Command, CommandResponse}
import com.kozlowst.oms.common.models.Order
import com.kozlowst.oms.orderbot.config.OrderBotConfig

/**
  * Created by tomek on 4/12/17.
  */

object ClientCheckAsk {
  def props(clientBotProxy: ActorRef, exchangeProxy: ActorRef): Props = Props(new ClientCheckAsk(clientBotProxy, exchangeProxy))
}

class ClientCheckAsk(clientBotProxy: ActorRef, exchangeProxy: ActorRef) extends Actor with ActorLogging with OrderBotConfig {

  override def receive: Receive = {
    case command: Command[Order] => {
      log.info("Send Command ORDER to ClientBot for verification. ORDER: {}", command.obj)
      clientBotProxy ! command
      context.become(waitForResponse)
    }
  }

    def waitForResponse: Receive = {
    case response: CommandResponse[Order] => {
      log.info("Received response from ClientBot for ORDER: {}", response.command.obj)
      val command = response.command.copy(topic = exchangeTopic)
      exchangeProxy ! command
      log.info("Response forwarded to OrderBot: {}", command)
      context.stop(self)
    }
  }
}

