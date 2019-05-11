package bme.moblab.weatheranal.model

import com.google.gson.annotations.SerializedName

data class WeatherRoot(
    @SerializedName("main")
    var main: Weather)