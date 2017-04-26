package com.kozlowst.oms.common.values

/**
  * Created by tomek on 4/25/17.
  */
object ExecType extends Enumeration {

  type ExecType = Value

  /**
    * Order Accepted
    * Indicates that a new order has been accepted.
    *
    * OrderStatus:
    * 0 = New
    * */
  val New = Value("0")

  /**
    * Order Rejected
    * Indicates that an order has been rejected.
    * The reason for the rejection is specified in the field OrdRejReason (103).
    *
    * OrderStatus:
    * 8 = Rejected
    * */
  val Rejected = Value("8")

  /**
    * Order Expired
    * Indicates that an order has been expired.
    * OrigClOrdID field will not be provided in this Execution Report.
    *
    * OrderStatus:
    * C = Expired
    * */
  val Expired = Value("C")

  /**
    * Order Executed (Trade)
    * Indicates that an order has been partially or fully filled.
    * The execution details (e.g., price and quantity) are specified.
    *
    * OrderStatus:
    * 1 = Partially Filled
    * 2 = Filled
    * */
  val Trade = Value("F")

  /**
    * Order Cancelled
    * Indicates that an Order Cancel Request has been accepted and successfully processed.
    * This message can also be sent unsolicited in which case the Execution Report may include
    * the ExecRestatementReason field to indicate the reason for cancellation; OrigClOrdID field
    * will not be provided.
    *
    * OrderStatus:
    * 4 = Cancelled
    * */
  val Cancelled = Value("4")

  /**
    * Order Replaced
    * Indicates that an Order Cancel/Replace Qequest has been accepted and successfully processed.
    *
    * OrderStatus:
    * 0 = New
    * 1 = Partially Filled
    * 2 = Filled
    * */
  val Replaced = Value("5")

  /**
    * Trade Cancel
    * Indicates that an execution has been cancelled by Market Operations.
    * The message will include an ExecRefID to identify the execution being cancelled
    * and the updated execution details (e.g., price and quantity).
    *
    * OrderStatus:
    * 0 = New
    * 1 = Partially Filled
    * 2 = Filled
    * 4 = Cancelled
    * C = Expired
    * */
  val TradeCancel = Value("H")

}
