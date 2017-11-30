package com.tonykazanjian.kotlinweatherapp

import android.app.Application
import com.tonykazanjian.kotlinweatherapp.extensions.DelegatesExt

/**
 * @author Tony Kazanjian
 */
class App : Application() {


    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}