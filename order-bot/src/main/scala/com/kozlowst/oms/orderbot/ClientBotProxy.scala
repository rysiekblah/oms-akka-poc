package com.kozlowst.oms.orderbot

import com.kozlowst.oms.common.cluster.PubSub
import com.kozlowst.oms.common.commands.Command
import com.kozlowst.oms.common.models.Order
import com.kozlowst.oms.orderbot.config.OrderBotConfig

/**
  * Created by tomek on 4/12/17.
  */
class ClientBotProxy extends OrderBotConfig with PubSub[Order]{

  override def topic: String = clientBotTopic

  override def handleResponse(reqId: Long, command: Command[Order]): Unit = {

  }

}
