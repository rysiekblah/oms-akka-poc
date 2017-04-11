package com.kozlowst.oms.common.commands

import akka.remote.ContainerFormats.ActorRef

/**
  * Created by tomek on 4/10/17.
  */
case class CommandSync(topic: String, obj: Any, actor: ActorRef)
