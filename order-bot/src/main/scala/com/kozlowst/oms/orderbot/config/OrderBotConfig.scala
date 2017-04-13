package com.kozlowst.oms.orderbot.config

import com.kozlowst.oms.common.config.CommonConfig

import scala.util.Try

/**
  * Created by tomek on 4/12/17.
  */
trait OrderBotConfig extends CommonConfig {
  lazy val exchangeTopic = Try(config.getString("oms.cluster.proxies.order-bot.exchange.topic")).getOrElse("default-exchange-topic")
  lazy val clientBotTopic = Try(config.getString("oms.cluster.proxies.order-bot.client-bot.topic")).getOrElse("default-client-bot-topic")
}
