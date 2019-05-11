package bme.moblab.weatheranal

import android.app.Activity

val Activity.injector: WeatherApplicationComponent
get () {
    return (this.applicationContext as WheaterApplication).injector
}