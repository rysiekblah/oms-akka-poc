package com.kozlowst.oms.rest

import akka.actor.{Actor, ActorLogging, Address}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.{MemberEvent, MemberRemoved, MemberUp, UnreachableMember}

/**
  * Created by tomek on 4/8/17.
  */
class ClusterListener extends Actor with ActorLogging {

  val cluster = Cluster(context.system)

  override def preStart(): Unit = cluster.subscribe(self, classOf[MemberEvent], classOf[UnreachableMember])

  override def postStop(): Unit = cluster.unsubscribe(self)

  override def receive: Receive = {
    case MemberUp(member) => log.info("Member is UP: {}", member.address)
    case MemberRemoved(member, prevStatus) => log.info("Member REMOVED: {} after {}", member, prevStatus)
    case UnreachableMember(member) => log.info("Member detected UNREACHABLE: {}", member)
  }
}
