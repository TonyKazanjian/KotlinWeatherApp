package com.tonykazanjian.kotlinweatherapp.data

import com.tonykazanjian.kotlinweatherapp.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

import com.tonykazanjian.kotlinweatherapp.model.Forecast as ModelForecast

/**
 * @author Tony Kazanjian
 */

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ResponseClasses.ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))


    private fun convertForecastListToDomain(list : List<ResponseClasses.Forecast>) : List<ModelForecast> {

        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: ResponseClasses.Forecast) : ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long) : String {
        val dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dateFormat.format(date)
    }
}