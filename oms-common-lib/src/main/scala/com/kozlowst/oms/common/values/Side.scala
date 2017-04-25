package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/23/17.
  */
object Side extends Enumeration {
  type Side = Value
  val Buy = Value(1)
  val Sell = Value(2)
  val SellShort = Value(5)
}
