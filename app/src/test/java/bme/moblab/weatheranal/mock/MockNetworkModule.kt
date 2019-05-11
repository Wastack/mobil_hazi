package bme.moblab.weatheranal.mock


import bme.moblab.weatheranal.network.WeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi = MockWeatherApi()

}
