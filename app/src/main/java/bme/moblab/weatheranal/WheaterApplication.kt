package bme.moblab.weatheranal

import android.app.Application
import bme.moblab.weatheranal.WeatherApplicationComponent
import bme.moblab.weatheranal.ui.UIModule

class WheaterApplication : Application() {
    lateinit var injector: WeatherApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerWeatherApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

}