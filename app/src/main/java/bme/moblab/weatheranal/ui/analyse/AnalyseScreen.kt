package bme.moblab.weatheranal.ui.analyse

import bme.moblab.weatheranal.model.StoredWeather

interface AnalyseScreen {
    fun updateDiagram(w: List<StoredWeather>)
}