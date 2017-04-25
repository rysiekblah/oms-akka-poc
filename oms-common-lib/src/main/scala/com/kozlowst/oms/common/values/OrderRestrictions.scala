package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/25/17.
  */
object OrderRestrictions extends Enumeration {

  type OrderRestrictions = Value

  val Arbitrage = Value(2)

  val MarketMaker = Value(5)

  val MarketMakerDerivative = Value(6)

}
