package com.kozlowst.oms.common

import com.typesafe.config.ConfigFactory
import org.scalatest._

/**
  * Created by tomek on 4/8/17.
  */
class ConfigTest extends FlatSpec with Matchers {

  "DummyConfiguration" should "load common configuration" in {
    ConfigFactory.invalidateCaches()
    System.setProperty("config.resource","application-1.conf")
    val config = new DummyConfiguration
    config.actorSystemName should be ("oms-cluster")
    config.addressProtocol should be ("akka.tcp")
    config.addressHost should be ("127.0.0.1")
    config.addressPort should be (50478)
    config.topicOms should be ("event-oms")
    config.topicLog should be ("event-log")
    config.appName should be ("oms-cluster")
  }

  "DummyConfiguration" should "load default values" in {
    ConfigFactory.invalidateCaches()
    System.setProperty("config.resource","application-2.conf")
    val config = new DummyConfiguration
    config.actorSystemName should be ("default-oms-cluster-name")
    config.addressProtocol should be ("akka.tcp")
    config.addressHost should be ("127.0.0.1")
    config.addressPort should be (50400)
    config.topicOms should be ("default-topic-oms")
    config.topicLog should be ("default-topic-log")
  }

}
