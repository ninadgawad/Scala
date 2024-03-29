package com.ninad
import com.ninad.ConfigReader.{readApiKey, readApiUrl}

import java.net.{HttpURLConnection, URL}
import java.io.BufferedReader
import java.io.InputStreamReader


object WeatherApiCaller {


  private def getWeatherInfo(city: String): String={
    val apiKey = readApiKey()
    val apiUrl = readApiUrl()
    val urlString = s"$apiUrl/data/2.5/weather?q=$city&appid=$apiKey&units=imperial"
    val url = new URL(urlString)
    val connection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("GET")

    val responseCode = connection.getResponseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
      val reader = new BufferedReader(new InputStreamReader(connection.getInputStream))
      var inputLine: String = reader.readLine
      while (inputLine != null) {
        println("Weather for City:"+city)
        println(inputLine)
        inputLine = reader.readLine

      }
      reader.close()
      inputLine
    } else {
      println("Error making the request")
      "Error"
    }
  }


  def main(args: Array[String]): Unit = {
    val city = "New York"
    getWeatherInfo(city)

  }
}
