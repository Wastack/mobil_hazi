package bme.moblab.weatheranal

import bme.moblab.weatheranal.interactor.InteractorModule
import bme.moblab.weatheranal.mock.MockNetworkModule
import bme.moblab.weatheranal.test.MainTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : WeatherApplicationComponent {
    fun inject(mainTest: MainTest)
}
