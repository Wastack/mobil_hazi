package bme.moblab.weatheranal.mock

import bme.moblab.weatheranal.model.Weather
import bme.moblab.weatheranal.model.WeatherRoot
import bme.moblab.weatheranal.network.WeatherApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import java.io.IOException
import java.util.*

class MockWeatherApi : WeatherApi {
    override fun getWeather(@Query("q") city_name: String,@Query("appid") appid: String): Call<WeatherRoot> {

        val weatherResult = WeatherRoot(
            Weather(294.77, 1012.0, 40.0, 293.71, 295.93)
        )

        val call = object : Call<WeatherRoot> {
            @Throws(IOException::class)
            override fun execute(): Response<WeatherRoot> {
                return Response.success(weatherResult)
            }

            override fun enqueue(callback: Callback<WeatherRoot>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<WeatherRoot> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }


}
