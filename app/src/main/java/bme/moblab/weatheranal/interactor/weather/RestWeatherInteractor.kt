package bme.moblab.weatheranal.interactor.weather

import bme.moblab.weatheranal.model.Weather
import bme.moblab.weatheranal.network.WeatherApi
import javax.inject.Inject

class RestWeatherInteractor @Inject constructor(private var weatherApi: WeatherApi) {
    fun getCurrentWeather() : Weather {
        val weatherQueryCall = weatherApi.getWeather("Budapest", "01d73773be37f4a59113bd832c9a2685")
        val response = weatherQueryCall.execute()
        return response.body()!!.main
    }
}