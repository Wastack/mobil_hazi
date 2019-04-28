package bme.moblab.weatheranal.ui.append

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import bme.moblab.weatheranal.R

import javax.inject.Inject

class AppendActivity : AppCompatActivity(), AppendScreen {

    @Inject
    lateinit var appendPresenter: AppendPresenter

    override fun onStart() {
        super.onStart()
        appendPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        appendPresenter.detachScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
