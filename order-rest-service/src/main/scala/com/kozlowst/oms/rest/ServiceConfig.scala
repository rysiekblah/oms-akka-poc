package com.kozlowst.oms.rest

import com.kozlowst.oms.common.CommonConfig

import scala.util.Try

/**
  * Created by tomek on 4/8/17.
  */
trait ServiceConfig extends CommonConfig {
  lazy val restSvcHost = Try(config.getString("oms.rest-service.host")).getOrElse("0.0.0.0")
  lazy val restSvcPort = Try(config.getInt("oms.rest-service.port")).getOrElse(8888)
}
