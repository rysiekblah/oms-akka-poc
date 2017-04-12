package com.kozlowst.oms.common.utils

import java.text.SimpleDateFormat
import java.util.Calendar

/**
  * Created by tomek on 4/11/17.
  */
object DateUtils {

  def getCurrentDate: String = getCurrentDateTime("EEEE, MMMM d")

  def getCurrentTime: String = getCurrentDateTime("K:m aa")

  private def getCurrentDateTime(dateTimeFormat: String): String =
    new SimpleDateFormat(dateTimeFormat).format(Calendar.getInstance())

}
