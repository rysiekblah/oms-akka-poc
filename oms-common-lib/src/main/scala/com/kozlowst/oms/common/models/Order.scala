package com.kozlowst.oms.common.models

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by tomek on 4/6/17.
  */

case class Order (
                orderId: Option[Long],
                accountName: String,
                cumQty: Long, // Cumulative quantity filled
                comment: String, // User generated comment
                commission: Double, // Commission charged (positive value)
                createdByID: String, //	User ID of order
                createdWhen: String, //	Date/time order was created.
                instrumentId: Long,
                leavesQty: Double, // Quantity remaining to be filled.
                orderQty: Long, //	Number of shares
                orderType: Int,
                side: Int,
                orderStatus: Int,
                autoStop: Int // Auto-generated stop order placed this percentage below VWAP.
                              // The stop order is placed after this market order is executed.
                              // "Auto-Stop" Calculation: AP - (AP x autoStop).
                )

object Order {

  def createMarketOrd(accountName: String, comment: String, createdByID: String, instrumentId: Long,
                      orderQty: Long, side: Int, autoStop: Int) = {
    Order(Some(0L), accountName, 0L, comment, 0.0, createdByID, timeNow, instrumentId, orderQty, orderQty,
      OrderType.Market.id, side, OrderStatus.New.id, autoStop)
  }

  def createLimitOrd() = ???

  val timeNow = DateTime.now().toString(DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss"))
}

object OrderType extends Enumeration {
  type OrderType = Value
  val Market = Value(1)
  val Limit = Value(2)
  val Stop = Value(3)
}

object Side extends Enumeration {
  type Side = Value
  val Buy = Value(1)
  val Sell = Value(2)
}

object OrderStatus extends Enumeration {
  type OrderStatus = Value
  val New = Value(0)
  val PartialFill = Value(1)
  val Fill = Value(2)
  val Paused = Value(3)
  val Cancelled = Value(4)
  val Verified = Value(5)
  val Rejected = Value(8)
}
