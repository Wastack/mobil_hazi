package bme.moblab.weatheranal.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bme.moblab.weatheranal.R
import bme.moblab.weatheranal.injector
import bme.moblab.weatheranal.model.StoredWeather
import java.util.*
import javax.inject.Inject
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import bme.moblab.weatheranal.ui.analyse.AnalyseActivity
import bme.moblab.weatheranal.ui.append.AppendActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList




class MainActivity : AppCompatActivity(), MainScreen {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MainListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var swipeContainer: SwipeRefreshLayout
    private lateinit var fab: FloatingActionButton
    private lateinit var appendButton: FloatingActionButton
    private lateinit var analyseButton: FloatingActionButton

    private lateinit var weatherList : ArrayList<StoredWeather>

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injector.inject(this)
        swipeContainer = findViewById(R.id.swipe_layout)
        swipeContainer.setOnRefreshListener {
            // Your code to refresh the list here.
            mainPresenter.refreshWeatherData()
            swipeContainer.setRefreshing(false)
        }

        viewManager = LinearLayoutManager(this)
        weatherList =  arrayListOf<StoredWeather>(StoredWeather(
            12, 0.0, 0.0, 0.0, 0.0, Date()))
        viewAdapter = MainListAdapter(this, weatherList)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            mainPresenter.queryCurrentWeather(Date())
        }
        appendButton = findViewById(R.id.append_button)
        appendButton.setOnClickListener {
            val intent = Intent(this, AppendActivity::class.java)
            startActivity(intent)
        }
        analyseButton = findViewById(R.id.analyse_button)
        analyseButton.setOnClickListener {
            val intent = Intent(this, AnalyseActivity::class.java)
            startActivity(intent)
        }

        // retrieve data if sent by append activity
        val extras = intent.extras
        mainPresenter.updateWeatherWith(extras?.getDouble("temperature"), extras?.getString("date"))
    }

    override fun showWeatherData(data : List<StoredWeather>) {
        weatherList.clear()
        weatherList.addAll(data)

        this.runOnUiThread {
            viewAdapter.notifyDataSetChanged()
        }
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
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
