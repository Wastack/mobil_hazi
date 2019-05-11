package bme.moblab.weatheranal.model

import java.util.*

fun weatherToStored( w: Weather, d: Date ) : StoredWeather {
        return StoredWeather(id=null, temperature = w.temp, humidity = w.humidity,
            temp_min = w.temp_min, temp_max = w.temp_max, date = d
        )
}