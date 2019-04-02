package bme.moblab.weatheranal.ui

import android.content.Context
import bme.moblab.weatheranal.ui.main.AppendPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private  val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter() = AppendPresenter()


}