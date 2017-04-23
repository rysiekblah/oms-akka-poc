package com.kozlowst.oms.common.models

import com.kozlowst.oms.common.utils.DateUtils
import com.kozlowst.oms.common.values.{OrderStatus, OrderType}
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
    Order(Some(0L), accountName, 0L, comment, 0.0, createdByID, DateUtils.timeNow, instrumentId, orderQty, orderQty,
      OrderType.Market.id, side, OrderStatus.New.id, autoStop)
  }

  def createLimitOrd() = ???
}






