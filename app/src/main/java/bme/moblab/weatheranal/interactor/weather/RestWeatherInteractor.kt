package bme.moblab.weatheranal.interactor.weather

import bme.moblab.weatheranal.model.Weather
import bme.moblab.weatheranal.network.WeatherApi
import javax.inject.Inject

class RestWeatherInteractor @Inject constructor(private var weatherApi: WeatherApi) {
    fun getCurrentWeather() : Weather? {
        val weatherQueryCall = weatherApi.getWeather("Budapest")
        val response = weatherQueryCall.execute()
        return response.body()?.weather
    }
}