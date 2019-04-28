package bme.moblab.weatheranal.interactor

import bme.moblab.weatheranal.interactor.weather.RestWeatherInteractor
import bme.moblab.weatheranal.network.WeatherApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun restWeatherInteractor(weatherApi : WeatherApi) = RestWeatherInteractor(weatherApi)
}