package com.example.jadwalsholat.fragment

import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.jadwalsholat.data.currentLocation
import com.example.jadwalsholat.databinding.HomeBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.logging.SimpleFormatter

class HomeFragment:Fragment() {
    private var _binding: HomeBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val locationDataAdapter = LocationDataAdapter(
        onlocationClicked = {
            Toast.makeText(requireContext(),"onLocationClicked()", Toast.LENGTH_SHORT).show()
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
        _binding = HomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLocationDataAdapter()
        setLocationData()
    }

    private fun setLocationDataAdapter(){
        binding.locationDataRecyclerView.adapter = locationDataAdapter
    }

    private fun setLocationData(){
        locationDataAdapter.setData(data = listOf(currentLocation(date = getCurrentDate())))

    }
    private fun getCurrentDate(): String {
        val CurrentDate = Date()
        val formatter = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        return "Today, ${formatter.format(CurrentDate)} "
    }
}