package com.tonykazanjian.kotlinweatherapp.data

import android.util.Log
import java.net.URL

/**
 * @author Tony Kazanjian
 * @param url The url for the constructor to receive
 *
 */
class Request(private val url: String) {

    /**
     * Reads the url result and outputs it in the log
     */
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}