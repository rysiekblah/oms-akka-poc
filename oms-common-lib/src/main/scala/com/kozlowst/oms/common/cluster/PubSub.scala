package com.kozlowst.oms.common.cluster

/**
  * Created by tomek on 4/11/17.
  */

class PubSub[T](topic: String) extends Subscriber[T](topic) {
  override def handle(obj: T): Unit = ???
}
