package com.kozlowst.oms.common

/**
  * Created by tomek on 4/7/17.
  */
trait EventHandler {
  def handle(order: Order)
}
