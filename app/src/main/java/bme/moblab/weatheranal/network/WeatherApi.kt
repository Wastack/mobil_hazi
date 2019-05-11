package bme.moblab.weatheranal.network

import bme.moblab.weatheranal.model.WeatherRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getWeather(
        @Query("q") city_name: String,
        @Query("appid") appid: String
    ): Call<WeatherRoot>
}