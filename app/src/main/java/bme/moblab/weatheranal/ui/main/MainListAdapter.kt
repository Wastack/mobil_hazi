package bme.moblab.weatheranal.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bme.moblab.weatheranal.R
import bme.moblab.weatheranal.model.StoredWeather
import kotlinx.android.synthetic.main.main_list_elem.view.*
import java.text.SimpleDateFormat


class MainListAdapter constructor(
        private val context: Context,
        private var weathers: ArrayList<StoredWeather>) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.main_list_elem, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = weathers[position]
        holder.temperature.text = "%.2f °C".format(weather.temperature!! - 273.15)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        holder.date.text = dateFormat.format(weather.date)

    }

    override fun getItemCount() = weathers.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var temperature: TextView = view.temperature
        var date: TextView = view.date
    }
}
