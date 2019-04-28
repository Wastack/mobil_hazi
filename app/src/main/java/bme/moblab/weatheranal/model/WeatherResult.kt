package bme.moblab.weatheranal.model

import com.google.gson.annotations.SerializedName

data class WeatherResult(
    @SerializedName("Weather")
    var weather: Weather? = null
)