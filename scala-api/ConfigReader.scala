package com.ninad

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.{File, FileInputStream}

object ConfigReader {
  def readApiKey(): String = {
    val configFile = "C:\\MyData\\Ninad\\Learning\\scala-at-light-speed-start\\src\\main\\resources\\config.yml"
    val inputStream =  new FileInputStream(new File(configFile))
    val yaml = new Yaml(new Constructor(classOf[OpenWeatherMap]))
    val e = yaml.load(inputStream).asInstanceOf[OpenWeatherMap]
    e.apiKey
  }
}
