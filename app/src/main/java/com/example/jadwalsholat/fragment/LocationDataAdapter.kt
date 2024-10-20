package com.example.jadwalsholat.fragment

import androidx.recyclerview.widget.RecyclerView
import com.example.jadwalsholat.data.currentLocation
import com.example.jadwalsholat.data.locationdata
import com.example.jadwalsholat.databinding.ActivityMainBinding

class LocationDataAdapter(
    private val onlocationClicked: () -> Unit
) {

    private val locationDataAdapter = mutableListOf<locationdata>()

    inner class CurrentLocationViewHolder(
        private val binding: ActivityMainBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(currentLocation: currentLocation){
            with(binding){
                textCurrentDate.text
            }
        }
    }
}