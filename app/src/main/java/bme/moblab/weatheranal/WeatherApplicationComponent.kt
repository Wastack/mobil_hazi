package bme.moblab.weatheranal

import bme.moblab.weatheranal.interactor.InteractorModule
import bme.moblab.weatheranal.network.NetworkModule
import bme.moblab.weatheranal.ui.UIModule
import bme.moblab.weatheranal.ui.analyse.AnalyseActivity
import bme.moblab.weatheranal.ui.append.AppendActivity
import bme.moblab.weatheranal.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface WeatherApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(appendActivity: AppendActivity)
    fun inject(analyseActivity: AnalyseActivity)

}