package com.ninad

import scala.beans.BeanProperty

class OpenWeatherMap {
  @BeanProperty var apiKey = ""
  @BeanProperty var apiUrl = ""
  override def toString: String = s"apiKey: $apiKey apiUrl:$apiUrl"
}
