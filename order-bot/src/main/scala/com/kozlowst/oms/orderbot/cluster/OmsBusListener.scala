package com.kozlowst.oms.orderbot.cluster

import akka.actor.{ActorRef, Props}
import com.kozlowst.oms.common.cluster.Subscriber
import com.kozlowst.oms.common.commands.Command
import com.kozlowst.oms.common.models.Order
import com.kozlowst.oms.orderbot.config.OrderBotConfig

/**
  * Created by tomek on 4/13/17.
  */

//clientBotProxy, exchangeProxy

object OmsBusListener {
  def props(clientBotProxy: ActorRef, exchangeProxy: ActorRef): Props = Props(new OmsBusListener(clientBotProxy, exchangeProxy))
}

class OmsBusListener(clientBotProxy: ActorRef, exchangeProxy: ActorRef) extends OrderBotConfig with Subscriber[Order] {
  override def topic: String = topicOms

  override def handle(obj: Order): Unit = {
    val worker = context.actorOf(ClientCheckAsk.props(clientBotProxy, exchangeProxy))
    log.info("OMS-BUS-LISTERNER got ORDER: {}", obj)
    worker ! Command[Order]("client", obj)
  }
}
