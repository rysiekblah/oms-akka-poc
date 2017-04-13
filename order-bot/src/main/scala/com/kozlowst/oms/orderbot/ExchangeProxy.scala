package com.kozlowst.oms.orderbot

import com.kozlowst.oms.common.cluster.Publisher
import com.kozlowst.oms.common.commands.CommandSync
import com.kozlowst.oms.common.models.Order

/**
  * Created by tomek on 4/12/17.
  */
class ExchangeProxy extends Publisher[Order] {
  override def handleSync(commandSync: CommandSync): Receive = {
    case _ => log.info("")
  }
}
