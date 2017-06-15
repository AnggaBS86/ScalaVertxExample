package com.ab.utils

import java.util.logging.Logger


/**
  * [Documentation Here]
  *
  * @author Angga Bayu S
  */
class MyLogger(className: String) {

  def info(stringInfo: String): Unit = Logger.getLogger(className).info(stringInfo)

  def warning(stringWarn: String): Unit = Logger.getLogger(className).warning(stringWarn)

  def error(stringError: String): Unit = Logger.getLogger(className).severe(stringError)

}
