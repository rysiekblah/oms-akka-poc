package com.kozlowst.oms.common.fix.messages

import com.kozlowst.oms.common.fix.values.Tag35
import com.kozlowst.oms.common.values.ExecType.ExecType
import com.kozlowst.oms.common.values.OrderCapacity.OrderCapacity
import com.kozlowst.oms.common.values.OrderLotType.OrderLotType
import com.kozlowst.oms.common.values.OrderRestrictions.OrderRestrictions
import com.kozlowst.oms.common.values.OrderStatus.OrderStatus
import com.kozlowst.oms.common.values.OrderType.OrderType
import com.kozlowst.oms.common.values.Side.Side
import com.kozlowst.oms.common.values.TimeInForce.TimeInForce

/**
  * Created by tomek on 4/23/17.
  */
case class ExecutionReport(
                          msgType:String = Tag35.ExecutionReport.toString,
                          clOrdID:Long,
                          orderID:Long,
                          execID:Long,
                          // Role
                          noPartyIDs:Int,
                          partyId:Long,
                          partyIdSource:String,
                          partyRole:String,
                          //Instrument
                          securityId:Long,
                          securityIdSource:Int, // = 8
                          securityExchange:Option[String], // stock ex code
                          // order
                          //execInstr:Option[String],
                          orderType:OrderType,
                          text:Option[String],
                          tif:Option[TimeInForce],
                          side:Side,
                          orderQty:Int,
                          price:Option[Double],
                          transactTime:String,
                          positionEffect:Option[String],
                          orderCapacity:Option[OrderCapacity],
                          orderRestrictions: Option[OrderRestrictions],
                          maxPriceLevels:Option[Int],
                          orderStatus:OrderStatus,
                          execType:ExecType,
                          cumQty:Double,
                          leavesQty:Double,
                          lotType:OrderLotType,
                          // Disclosure - for future use
                          noDisclosureInstructions:Int,
                          disclosureType:Int,
                          disclosureInstruction:Int
                          )
