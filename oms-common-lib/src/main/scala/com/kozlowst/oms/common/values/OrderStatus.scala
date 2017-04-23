package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/23/17.
  */
object OrderStatus extends Enumeration {
  type OrderStatus = Value

  val NEW                = Value('0')
  val PARTIALLY_FILLED   = Value('1')
  val FILLED             = Value('2')
  val CANCELLED          = Value('4')
  val PENDING_CANCEL     = Value('6')
  val REJECTED           = Value('8')
  val PENDING_NEW        = Value('A')
  val EXPIRED            = Value('C')
  val PENDING_REPLACE    = Value('E')
}
