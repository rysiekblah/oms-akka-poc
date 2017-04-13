package com.kozlowst.oms.orderbot

import akka.actor.{ActorSystem, Address, Props}
import akka.cluster.Cluster
import com.kozlowst.oms.common.commands.Command
import com.kozlowst.oms.common.models.Order
import com.kozlowst.oms.orderbot.cluster.{ClientBotProxy, ClientCheckAsk, ExchangeProxy, OmsBusListener}
import com.kozlowst.oms.orderbot.config.OrderBotConfig

/**
  * Created by tomek on 4/10/17.
  */
object Main extends App with OrderBotConfig {

  println(actorSystemName + ", " + exchangeTopic + ", " + clientBotTopic)

  implicit val system = ActorSystem(actorSystemName)
  Cluster(system).join(Address(addressProtocol, actorSystemName, addressHost, addressPort))
  val clientBotProxy = system.actorOf(Props[ClientBotProxy], "clientbot-proxy-actor")
  val exchangeProxy = system.actorOf(Props[ExchangeProxy], "exchange-proxy-actor")
  val omsListener = system.actorOf(OmsBusListener.props(clientBotProxy, exchangeProxy), "oms-but-listener")

//  val worker = system.actorOf(ClientCheckAsk.props(clientBotProxy, exchangeProxy))
  val command: Command[Order] =
    Command("", Order(Some(1), "acount", 100L, "comment", 122.2, "Tim", "today", 12345L, 22.2, 300, 1, 1, 1, 14))
  Thread.sleep(5000)
  println("Sending order")
  omsListener ! command

}
