package com.tonykazanjian.kotlinweatherapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tonykazanjian.kotlinweatherapp.R
import com.tonykazanjian.kotlinweatherapp.extensions.ctx
import com.tonykazanjian.kotlinweatherapp.model.Forecast
import com.tonykazanjian.kotlinweatherapp.model.ForecastList
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * @author Tony Kazanjian
 */
class ForecastListAdapter(val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx) .inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast){
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)

    }
}