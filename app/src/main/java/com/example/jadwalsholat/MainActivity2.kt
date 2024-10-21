package com.example.jadwalsholat

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jadwalsholat.model.Item

class MainActivity2 : AppCompatActivity(), ISholatView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SholatPresenter(this).getDataFromAPI("Bandung")
    }

    override fun onDataFromAPI(solat: Item) {
        val timeSubuhTextView = findViewById<TextView>(R.id.timesubuh)
        timeSubuhTextView.text = solat.fajr
    }

    override fun onDataErrorFromAPI(throwable: Throwable) {
        error("error ==========> ${throwable.localizedMessage}")
    }

}