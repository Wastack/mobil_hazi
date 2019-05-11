package bme.moblab.weatheranal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "weather")
@TypeConverters(DateConverter::class)
data class StoredWeather (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    // in Kelvin
    @ColumnInfo(name = "temperature") var temperature: Double?,
    @ColumnInfo(name = "humidity") var humidity: Double,
    @ColumnInfo(name = "temp_min") var temp_min: Double,
    @ColumnInfo(name = "temp_max") var temp_max: Double,
    @ColumnInfo(name = "date") var date: Date
){
    constructor():this(null,0.0,0.0,0.0,0.0, Date())
}