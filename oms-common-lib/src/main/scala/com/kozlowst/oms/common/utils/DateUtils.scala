package com.kozlowst.oms.common.utils

import java.text.SimpleDateFormat
import java.util.Calendar

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
  * Created by tomek on 4/11/17.
  */
object DateUtils {

  def getCurrentDate: String = getCurrentDateTime("EEEE, MMMM d")

  def getCurrentTime: String = getCurrentDateTime("K:m aa")

  def timeNow: String = timeNow("dd-MM-yyyy hh:mm:ss")

  def timeNow(format: String): String =  DateTime.now().toString(DateTimeFormat.forPattern(format))

  private def getCurrentDateTime(dateTimeFormat: String): String =
    new SimpleDateFormat(dateTimeFormat).format(Calendar.getInstance())

}
