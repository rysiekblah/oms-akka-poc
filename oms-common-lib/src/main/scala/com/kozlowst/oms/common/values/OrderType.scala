package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/23/17.
  */
object OrderType extends Enumeration {

  type OrderType = Value

  /*
  * Market Order
  * An order that will execute at the best available prices until it is fully filled.
  * Any remainder will be expired.
  *
  * Relevant fix tags
  * OrderType (40) = 1
  */
  val MARKET = Value(1)

  /*
  * Limit Order
  * An order that will execute at or better than the specified price. The remainder, if any, is added
  * to the order book or expired in terms of its TimeInForce
  *
  * Relevant fix tags:
  * OrderType (40) = 2
  * */
  val LIMIT = Value(2)

  /*
  * Stop Order
  * A market order that remains inactive until the market reaches a specified stop price.
  *
  * Relevant fix tags:
  * OrderType (40) = 3
  * StopPx (99)
  * */
  val STOP = Value(3)

  /*
  * Stop Limit Order
  * A limit order that remains inactive until the market reaches a specified stop price.
  *
  * Relevant fix tags:
  * OrderType (40) = 4
  * StopPx (99)
  * Price (44)
  * */
  val STOP_LIMIT = Value(4)
}
