package com.kozlowst.oms.orderbot

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.kozlowst.oms.common.commands.{Command, CommandResponse}
import com.kozlowst.oms.common.models.Order
import com.kozlowst.oms.orderbot.config.OrderBotConfig

/**
  * Created by tomek on 4/12/17.
  */

object ClientCheckAsk {
  def props(clientBot: ActorRef, orderBot: ActorRef): Props = Props(new ClientCheckAsk(clientBot, orderBot))
}

class ClientCheckAsk(clientBot: ActorRef, orderBot: ActorRef) extends Actor with ActorLogging with OrderBotConfig {

  override def receive: Receive = {
    case command: Command[Order] => {
      log.info("Send Command ORDER to ClientBot for verification. ORDER: {}", command.obj)
      clientBot ! command
      context.become(waitForResponse)
    }
  }

    def waitForResponse: Receive = {
    case response: CommandResponse[Order] => {
      log.info("Received response from ClientBot for ORDER: {}", response.command.obj)
      val command = response.command.copy(topic = exchangeTopic)
      orderBot ! command
      log.info("Response forwarded to OrderBot: {}", command)
      context.stop(self)
    }
  }
}

