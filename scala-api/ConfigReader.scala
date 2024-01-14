package com.ninad

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.{File, FileInputStream}

object ConfigReader {

  private val configFile =  "C:\\weather\\config.yml"

  private def readYaml(configFileLocation: String) : OpenWeatherMap = {
    val inputStream =  new FileInputStream(new File(configFileLocation))
    val yaml = new Yaml(new Constructor(classOf[OpenWeatherMap]))
    yaml.load(inputStream).asInstanceOf[OpenWeatherMap]
  }

  def readApiKey(): String = {
    readYaml(configFile).apiKey
  }

  def readApiUrl(): String = {
    readYaml(configFile).apiUrl
  }

}
