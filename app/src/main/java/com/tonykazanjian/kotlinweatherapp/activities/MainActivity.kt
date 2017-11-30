package com.tonykazanjian.kotlinweatherapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tonykazanjian.kotlinweatherapp.adapters.ForecastListAdapter
import com.tonykazanjian.kotlinweatherapp.R
import com.tonykazanjian.kotlinweatherapp.data.RequestForecastCommand
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("90028").execute()
            uiThread { forecastList.adapter = ForecastListAdapter(result) {
                toast(it.date) }
            }
        }
    }
}
