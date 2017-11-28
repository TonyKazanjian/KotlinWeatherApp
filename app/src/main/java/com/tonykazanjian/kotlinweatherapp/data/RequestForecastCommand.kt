package com.tonykazanjian.kotlinweatherapp.data

import com.tonykazanjian.kotlinweatherapp.domain.Command
import com.tonykazanjian.kotlinweatherapp.model.ForecastList

/**
 * @author Tony Kazanjian
 */
class RequestForecastCommand(private val zipCode : String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }
}