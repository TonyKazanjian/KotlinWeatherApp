package com.tonykazanjian.kotlinweatherapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.tonykazanjian.kotlinweatherapp.model.ForecastList

/**
 * @author Tony Kazanjian
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textview.text = "$date - $description - $high/$low"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview) {

    }
}