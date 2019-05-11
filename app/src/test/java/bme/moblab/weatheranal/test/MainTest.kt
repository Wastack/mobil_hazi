package bme.moblab.weatheranal.test

import bme.moblab.weatheranal.model.StoredWeather
import bme.moblab.weatheranal.testInjector
import bme.moblab.weatheranal.ui.main.MainPresenter
import bme.moblab.weatheranal.ui.main.MainScreen
import bme.moblab.weatheranal.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun test() {
        val date = Date()
        mainPresenter.queryCurrentWeather(date)

        verify(mainScreen, timeout(5000).atLeastOnce()).showWeatherData(arrayListOf(StoredWeather(1, 294.77, 40.0, 293.71, 295.93, date)))
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}