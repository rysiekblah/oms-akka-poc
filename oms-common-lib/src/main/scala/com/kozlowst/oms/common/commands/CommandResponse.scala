package com.kozlowst.oms.common.commands

/**
  * Created by tomek on 4/11/17.
  */
case class CommandResponse[+T](id: Long, uuid: String, command: Command[T])