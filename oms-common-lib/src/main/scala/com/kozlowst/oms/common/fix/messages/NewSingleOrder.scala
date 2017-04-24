package com.kozlowst.oms.common.fix.messages

import com.kozlowst.oms.common.fix.values.Tag35

/**
  * Created by tomek on 4/24/17.
  */
case class NewSingleOrder(
                         clOrdID:Long,
                         noPartyIDs:Int,
                         partyIdSource:String

                         ) {
  val msgType:String = Tag35.NewOrderSingle
}
