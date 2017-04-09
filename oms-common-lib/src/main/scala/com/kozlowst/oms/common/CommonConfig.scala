package com.kozlowst.oms.common

import com.typesafe.config.{Config, ConfigFactory}

import scala.util.Try

/**
  * Created by tomek on 4/8/17.
  */
trait CommonConfig {
  val config = ConfigFactory.load()

  lazy val actorSystemName = Try(config.getString("oms.cluster.actor.system.name")).getOrElse("default-oms-cluster-name")
  lazy val addressProtocol = Try(config.getString("oms.cluster.join.address.protocol")).getOrElse("akka.tcp")
  lazy val addressHost = Try(config.getString("oms.cluster.join.address.host")).getOrElse("127.0.0.1")
  lazy val addressPort = Try(config.getInt("oms.cluster.join.address.port")).getOrElse(50400)
  lazy val topicOms = Try(config.getString("oms.cluster.topic.oms")).getOrElse("default-topic-oms")
  lazy val topicLog = Try(config.getString("oms.cluster.topic.log")).getOrElse("default-topic-log")

}
