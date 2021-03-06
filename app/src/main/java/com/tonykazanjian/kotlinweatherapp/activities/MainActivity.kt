package com.tonykazanjian.kotlinweatherapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.tonykazanjian.kotlinweatherapp.adapters.ForecastListAdapter
import com.tonykazanjian.kotlinweatherapp.R
import com.tonykazanjian.kotlinweatherapp.data.ForecastRequest
import com.tonykazanjian.kotlinweatherapp.data.Request
import com.tonykazanjian.kotlinweatherapp.data.RequestForecastCommand
import com.tonykazanjian.kotlinweatherapp.model.Forecast
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("90028").execute()
            uiThread { forecastList.adapter = ForecastListAdapter(result,
                    object : ForecastListAdapter.OnItemClickListener{
                        override fun invoke(forecast: Forecast) {
                            toast(forecast.date)
                        }
                    })}
        }
    }
}
