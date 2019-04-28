package bme.moblab.weatheranal.network

import bme.moblab.weatheranal.model.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getWeather(
        @Query("q") city_name: String
    ): Call<WeatherResult>
}