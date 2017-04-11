package com.kozlowst.oms.common.commands

/**
  * Created by tomek on 4/11/17.
  */
case class CommandRequest[T](id: Long, command: Command[T])
