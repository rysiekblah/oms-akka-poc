package com.kozlowst.oms.common

import scala.util.Try

/**
  * Created by tomek on 4/8/17.
  */
class DummyConfiguration extends CommonConfig {

  lazy val appName = Try(config.getString("custom.app.name")).getOrElse("unknown")

}
