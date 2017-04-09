package com.kozlowst.oms.common

import com.kozlowst.oms.common.OrderStatus.OrderStatus
import com.kozlowst.oms.common.OrderType.OrderType
import com.kozlowst.oms.common.Side.Side
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by tomek on 4/6/17.
  */

case class Order (
                orderId: Long,
                accountName: String,
                cumQty: Long, // Cumulative quantity filled
                comment: String, // User generated comment
                commission: Double, // Commission charged (positive value)
                createdByID: String, //	User ID of order
                createdWhen: String, //	Date/time order was created.
                instrumentId: Long,
                leavesQty: Double, // Quantity remaining to be filled.
                orderQty: Long, //	Number of shares
                orderType: OrderType,
                side: Side,
                orderStatus: OrderStatus,
                autoStop: Int // Auto-generated stop order placed this percentage below VWAP.
                              // The stop order is placed after this market order is executed.
                              // "Auto-Stop" Calculation: AP - (AP x autoStop).
                ) {

  def isNew: Boolean = orderQty == leavesQty && orderStatus == OrderStatus.New

  def isFilled: Boolean = orderQty == cumQty && orderStatus == OrderStatus.Fill

  def isPartiallyFilled: Boolean = cumQty < orderQty && orderStatus == OrderStatus.PartialFill

  def isCancelled: Boolean = leavesQty == 0 && orderStatus == OrderStatus.Cancelled

  def isRejected: Boolean = leavesQty == 0 && orderStatus == OrderStatus.Rejected

}

object Order {

  def createMarketOrd(accountName: String, comment: String, createdByID: String, instrumentId: Long,
                      orderQty: Long, side: Side, autoStop: Int) = {
    Order(0L, accountName, 0L, comment, 0.0, createdByID, timeNow, instrumentId, orderQty, orderQty,
      OrderType.Market, side, OrderStatus.New, autoStop)
  }

  def fill(order:Order) = ???

  def cancel(order: Order) = ???

  val timeNow = DateTime.now().toString(DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss"))
}

object OrderType extends Enumeration {
  type OrderType = Value
  val Market, Limit, Stop = Value
}

object Side extends Enumeration {
  type Side = Value
  val Buy, Sell = Value
}

object OrderStatus extends Enumeration {
  type OrderStatus = Value
  val Failed = Value(-1)
  val New = Value(0)
  val PartialFill = Value(1)
  val Fill = Value(2)
  val Cancelled = Value(4)
  val Rejected = Value(8)
}
