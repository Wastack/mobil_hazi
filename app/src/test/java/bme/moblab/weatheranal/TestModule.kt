package bme.moblab.weatheranal

import android.content.Context
import bme.moblab.weatheranal.interactor.weather.RestWeatherInteractor
import bme.moblab.weatheranal.ui.analyse.AnalysePresenter
import bme.moblab.weatheranal.ui.append.AppendPresenter
import bme.moblab.weatheranal.ui.main.MainPresenter
import bme.moblab.weatheranal.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun mainPresenter(context: Context, executor: Executor, weatherInteractor: RestWeatherInteractor) =
        MainPresenter(context, executor, weatherInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = Executors.newFixedThreadPool(1)


    @Provides
    @Singleton
    fun appendPresenter() = AppendPresenter()

    @Provides
    @Singleton
    fun analysePresenter(context: Context, executor: Executor) = AnalysePresenter(context, executor)
}
