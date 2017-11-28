package com.tonykazanjian.kotlinweatherapp.data

import com.google.gson.Gson
import java.net.URL

/**
 * @author Tony Kazanjian
 */
class ForecastRequest(private val zipCode : String) {

    companion object {
        private val APP_ID = "03d4baffc10b590ba2203e23a476cca2"
        private val SAMPLE_APP_ID="b1b15e88fa797225412429c1c50c122a1"
        private val SAMPLE_ZIP = "94040"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val SAMPLE_URL = "http://samples.openweathermap.org/data/2.5/forecast/daily?zip="
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
        private val COMPLETE_SAMPLE_URL = "$SAMPLE_URL$SAMPLE_ZIP&appid=$SAMPLE_APP_ID"
    }

    fun execute() : ResponseClasses.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_SAMPLE_URL).readText()
        return Gson().fromJson(forecastJsonStr, ResponseClasses.ForecastResult::class.java)

    }
}