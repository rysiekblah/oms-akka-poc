package com.kozlowst.oms.common

import OrderStatus.OrderStatus

/**
  * Created by tomek on 4/7/17.
  */
case class Execution(
                    executionId: Long,
                    orderId: Long,
                    execStatus: OrderStatus,
                    executedWhen: String
                    )
