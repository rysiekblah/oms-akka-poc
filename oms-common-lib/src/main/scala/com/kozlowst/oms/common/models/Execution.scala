package com.kozlowst.oms.common.models

import com.kozlowst.oms.common.values.OrderStatus.OrderStatus

/**
  * Created by tomek on 4/7/17.
  */
case class Execution(
                    executionId: Long,
                    orderId: Long,
                    execStatus: OrderStatus,
                    executedWhen: String
                    )
