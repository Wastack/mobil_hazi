package bme.moblab.weatheranal.ui.analyse

import android.content.Context
import bme.moblab.weatheranal.dao.WeatherDataBase
import bme.moblab.weatheranal.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class AnalysePresenter @Inject constructor(private val context : Context, private val executor: Executor): Presenter<AnalyseScreen>() {
    fun getWeatherData() {
        val dbThread = Thread {
            val weathers = WeatherDataBase.getInstance(context)!!
                .weatherDataDao().getWeatherData()
            this.screen?.updateDiagram(weathers)
        }
        dbThread.start()
    }
}