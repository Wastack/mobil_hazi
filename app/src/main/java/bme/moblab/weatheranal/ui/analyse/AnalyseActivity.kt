package bme.moblab.weatheranal.ui.analyse

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import bme.moblab.weatheranal.R
import bme.moblab.weatheranal.injector
import bme.moblab.weatheranal.model.StoredWeather
import javax.inject.Inject

class AnalyseActivity : AppCompatActivity(), AnalyseScreen {
    override fun updateDiagram(w: List<StoredWeather>) {
        TODO("not implemented")
    }

    @Inject
    lateinit var analysePresenter: AnalysePresenter

    override fun onStart() {
        super.onStart()
        analysePresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        analysePresenter.detachScreen()
    }
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyse)
        injector.inject(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
