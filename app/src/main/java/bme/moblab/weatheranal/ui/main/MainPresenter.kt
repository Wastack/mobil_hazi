package bme.moblab.weatheranal.ui.main

import bme.moblab.weatheranal.ui.Presenter

class MainPresenter : Presenter<AppendScreen>() {
    fun refreshWeatherData() {
        throw NotImplementedError()
    }

    fun queryCurrentWeather() {
        throw NotImplementedError()
    }
}