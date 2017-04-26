package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/23/17.
  */
object OrderStatus extends Enumeration {
  type OrderStatus = Value

  val New               = Value('0')
  val PartiallyFilled   = Value('1')
  val Filled            = Value('2')
  val Cancelled         = Value('4')
  val PendingCancel     = Value('6')
  val Rejected          = Value('8')
  val PendingNew        = Value('A')
  val Expired           = Value('C')
  val PendingReplace    = Value('E')
}
