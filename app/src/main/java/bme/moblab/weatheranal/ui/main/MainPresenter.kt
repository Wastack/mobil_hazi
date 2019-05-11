package bme.moblab.weatheranal.ui.main

import android.content.Context
import bme.moblab.weatheranal.dao.WeatherDataBase
import bme.moblab.weatheranal.interactor.weather.RestWeatherInteractor
import bme.moblab.weatheranal.model.StoredWeather
import bme.moblab.weatheranal.model.weatherToStored
import bme.moblab.weatheranal.ui.Presenter
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val context : Context, private val executor: Executor, private val restInteractor: RestWeatherInteractor) : Presenter<MainScreen>() {
    fun refreshWeatherData() {
        val dbThread = Thread {
            val weathers = WeatherDataBase.getInstance(context)!!
                .weatherDataDao().getWeatherData()
            this.screen?.showWeatherData(weathers)
        }
        dbThread.start()
    }

    fun queryCurrentWeather(date : Date) {
        val thread = Thread {
            executor.execute {
                // TODO handle error
                val currentWeather = restInteractor.getCurrentWeather()
                // store new data
                WeatherDataBase.getInstance(context)!!.weatherDataDao().insertWeather(weatherToStored(currentWeather, date))
                refreshWeatherData()
            }
        }
        thread.start()
    }

    fun updateWeatherWith(temperature: Double?, dateText: String?) {
        if(temperature == null || dateText == null)
            return
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val date = dateFormat.parse(dateText)
        val dbThread = Thread {
            val currentWeather = StoredWeather(null, temperature, 0.0, 0.0, 0.0, date)
            WeatherDataBase.getInstance(context)!!.weatherDataDao().insertWeather(currentWeather)
            refreshWeatherData()
        }
        dbThread.start()
    }
}