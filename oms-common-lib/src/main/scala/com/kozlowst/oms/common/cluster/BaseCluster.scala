package com.kozlowst.oms.common.cluster

import akka.actor.{ActorSystem, Address}
import akka.cluster.Cluster
import com.kozlowst.oms.common.config.CommonConfig

/**
  * Created by tomek on 4/10/17.
  */
class BaseCluster extends CommonConfig {

  implicit val system = ActorSystem(actorSystemName)
  Cluster(system).join(Address(addressProtocol, actorSystemName, addressHost, addressPort))

}
