package com.kozlowst.oms.rest.models

/**
  * Created by tomek on 4/9/17.
  */
case class OrderRequest(accountName: String, comment: String, createdBy: String, instrumentId: Long,
                        size: Long, side: Int, autoStop: Int)
