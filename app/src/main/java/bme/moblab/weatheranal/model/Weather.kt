package bme.moblab.weatheranal.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("temp")
    var temp: Double,
    @SerializedName("pressure")
    var pressure: Double,
    @SerializedName("humidity")
    var humidity: Double,
    @SerializedName("temp_min")
    var temp_min: Double,
    @SerializedName("temp_max")
    var temp_max: Double
)