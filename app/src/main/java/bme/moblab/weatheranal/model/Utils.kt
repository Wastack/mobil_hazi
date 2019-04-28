package bme.moblab.weatheranal.model

fun weatherToStored( w: Weather ) : StoredWeather {
        return StoredWeather(id=null, temperature = w.temp, humidity = w.humidity,
            temp_min = w.temp_min, temp_max = w.temp_max)
}