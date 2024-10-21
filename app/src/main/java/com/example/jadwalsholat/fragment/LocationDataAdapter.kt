package com.example.jadwalsholat.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jadwalsholat.data.currentLocation
import com.example.jadwalsholat.data.locationdata
import com.example.jadwalsholat.databinding.ActivityMainBinding

class LocationDataAdapter(
    private val onlocationClicked: () -> Unit
) : RecyclerView.Adapter<LocationDataAdapter.CurrentLocationViewHolder>() {

    private val locationData = mutableListOf<locationdata>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<locationdata>){
        locationData.clear()
        locationData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentLocationViewHolder {
        return CurrentLocationViewHolder(
            ActivityMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrentLocationViewHolder, position: Int) {
        holder.bind(locationData[position] as currentLocation)
    }

    override fun getItemCount(): Int {
        return locationData.size
    }


    inner class CurrentLocationViewHolder(
        private val binding: ActivityMainBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(currentLocation: currentLocation){
            with(binding){
                textCurrentDate.text = currentLocation.date
                textCurrentLocation.text = currentLocation.location
                locationIcon.setOnClickListener { onlocationClicked() }
                textCurrentLocation.setOnClickListener { onlocationClicked() }
            }
        }
    }
}