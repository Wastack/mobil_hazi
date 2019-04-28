package bme.moblab.weatheranal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import bme.moblab.weatheranal.model.StoredWeather

@Dao
interface
WeatherDAO
{
    @Query("""SELECT * FROM weather""")
    fun getWeatherData() : List<StoredWeather>

    @Insert(onConflict = REPLACE)
    fun insertWeather(weather: StoredWeather)

    @Delete
    fun deleteWeather(weather: StoredWeather)
}