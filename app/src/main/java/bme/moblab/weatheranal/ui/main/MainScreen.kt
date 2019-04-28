package bme.moblab.weatheranal.ui.main

import bme.moblab.weatheranal.model.StoredWeather
import bme.moblab.weatheranal.ui.Screen

interface MainScreen: Screen {
    fun showWeatherData(data : List<StoredWeather>)
}