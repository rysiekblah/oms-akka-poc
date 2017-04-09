package com.kozlowst.oms.dumper

import akka.actor.{ActorSystem, Address, Props}
import akka.cluster.Cluster
import com.kozlowst.oms.order.common.CommonConfig

/**
  * Created by tomek on 4/7/17.
  */
object EventDumperApplication extends App with CommonConfig {

  implicit val system = ActorSystem(actorSystemName)

  val addr = Cluster(system).selfAddress
  println("Sub addr: " + addr)
  //"akka.tcp", "cluster", "127.0.1.1", 50478
  val joinAddr = Address(addressProtocol, actorSystemName, addressHost, addressPort)
  println("Join addr: " + joinAddr)
  Cluster(system).join(joinAddr)

  system.actorOf(Props[Subscriber], "subscriber1")

}
