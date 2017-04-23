package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/23/17.
  */
object TimeInForce extends Enumeration {

  type ValidityType = Value

  /*
  * Day
  * An order that will expire at the end of the day.
  *
  * Fix tag and value:
  * TimeInForce (59) = 0 (Default)
  * */
  val DAY = Value(0)

  /*
  * IOC - Immediate Or Cancel
  * An order that will be executed on receipt and the remainder, if any, immediately expired.
  *
  * Fix tag and value:
  * TimeInForce (59)= 3
  * */
  val IOC = Value(3)

  /*
  * FOK - Fill Or Kill
  * An order that will be fully executed on receipt or immediately expired.
  *
  * Fix tag and value:
  * TimeInForce (59)= 4
  * */
  val FOK = Value(4)

  /*
  * At Crossing
  * An order submitted during an Auction.
  *
  * Fix tag and value:
  * TimeInForce (59)= 9
  * */
  val CROSS = Value(9)

}
