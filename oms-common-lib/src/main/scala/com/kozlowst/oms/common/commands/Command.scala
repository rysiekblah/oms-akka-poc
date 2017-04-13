package com.kozlowst.oms.common.commands

/**
  * Created by tomek on 4/10/17.
  */
case class Command[+T](topic: String, obj: T)
