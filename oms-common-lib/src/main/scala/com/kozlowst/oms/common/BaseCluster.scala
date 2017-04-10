package com.kozlowst.oms.common

import akka.actor.{ActorSystem, Address}
import akka.cluster.Cluster

/**
  * Created by tomek on 4/10/17.
  */
class BaseCluster extends CommonConfig {

  implicit val system = ActorSystem(actorSystemName)
  Cluster(system).join(Address(addressProtocol, actorSystemName, addressHost, addressPort))

}
