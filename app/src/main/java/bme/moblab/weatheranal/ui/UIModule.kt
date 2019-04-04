package bme.moblab.weatheranal.ui

import android.content.Context
import bme.moblab.weatheranal.ui.main.AnalysePresenter
import bme.moblab.weatheranal.ui.main.AppendPresenter
import bme.moblab.weatheranal.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private  val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter() = MainPresenter()

    @Provides
    @Singleton
    fun appendPresenter() = AppendPresenter()

    @Provides
    @Singleton
    fun analysePresenter() = AnalysePresenter()
}