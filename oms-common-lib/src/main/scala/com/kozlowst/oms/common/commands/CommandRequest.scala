package com.kozlowst.oms.common.commands

/**
  * Created by tomek on 4/11/17.
  */
case class CommandRequest[+T](uuid: String, command: Command[T])
