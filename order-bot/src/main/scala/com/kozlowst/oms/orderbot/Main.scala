package com.kozlowst.oms.orderbot

import akka.actor.{ActorSystem, Address, Props}
import akka.cluster.Cluster
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
//  system.actorOf(ClientCheckAsk.props(clientBotProxy, exchangeProxy))

}
