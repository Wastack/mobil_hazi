package bme.moblab.weatheranal.ui.append

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import bme.moblab.weatheranal.R
import bme.moblab.weatheranal.injector
import bme.moblab.weatheranal.ui.main.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import javax.inject.Inject

class AppendActivity : AppCompatActivity(), AppendScreen {

    @Inject
    lateinit var appendPresenter: AppendPresenter

    lateinit var appendButton : FloatingActionButton
    lateinit var temp_box : EditText
    lateinit var date_box : EditText

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_append)
        injector.inject(this)
        appendButton = findViewById(R.id.append_unique_button)
        temp_box = findViewById(R.id.temp_box)
        date_box = findViewById(R.id.date_box)
        appendButton.setOnClickListener {
            if(temp_box.text.isEmpty() || date_box.text.isEmpty())
                return@setOnClickListener
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("temperature", temp_box.text.toString().toDouble() + 273.15)
            intent.putExtra("date", date_box.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        appendPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        appendPresenter.detachScreen()
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
