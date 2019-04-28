package bme.moblab.weatheranal.ui

import android.content.Context
import bme.moblab.weatheranal.interactor.weather.RestWeatherInteractor
import bme.moblab.weatheranal.ui.analyse.AnalysePresenter
import bme.moblab.weatheranal.ui.append.AppendPresenter
import bme.moblab.weatheranal.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private  val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(context: Context, executor: Executor, weatherInteractor: RestWeatherInteractor) =
        MainPresenter(context, executor, weatherInteractor)

    @Provides
    @Singleton
    fun appendPresenter() = AppendPresenter()

    @Provides
    @Singleton
    fun analysePresenter(context: Context, executor: Executor) = AnalysePresenter(context, executor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}