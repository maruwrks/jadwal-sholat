package com.example.jadwalsholat

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.jadwalsholat.model.Item
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity2 : AppCompatActivity(), ISholatView {

    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView

    private val handler = Handler()
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            updateTimeAndDate()
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeTextView = findViewById(R.id.Time)
        dateTextView = findViewById(R.id.Date)

        handler.post(updateTimeRunnable)

        lifecycleScope.launch {
            val presenter = SholatPresenter(this@MainActivity2)
            presenter.getDataFromAPI("bandung")
        }
    }

    private fun updateTimeAndDate() {
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val currentDate = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Date())

        timeTextView.text = currentTime
        dateTextView.text = currentDate
    }

    override fun onDataFromAPI(salat: Item) {
        val timeSubuhTextView = findViewById<TextView>(R.id.timesubuh)
        val timeDzuhurTextView = findViewById<TextView>(R.id.timeDzuhur)
        val timeAsarTextView = findViewById<TextView>(R.id.timeasar)
        val timeMaghribTextView = findViewById<TextView>(R.id.timemaghrib)
        val timeIsyaTextView = findViewById<TextView>(R.id.timeIsya)

        timeSubuhTextView.text = salat.fajr
        timeDzuhurTextView.text = salat.dhuhr
        timeAsarTextView.text = salat.asr
        timeMaghribTextView.text = salat.maghrib
        timeIsyaTextView.text = salat.isha
    }

    override fun onDataErrorFromAPI(throwable: Throwable) {
        error("error ==========> ${throwable.localizedMessage}")
    }
}
