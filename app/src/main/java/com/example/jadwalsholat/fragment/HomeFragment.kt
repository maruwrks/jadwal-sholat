package com.example.jadwalsholat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.jadwalsholat.databinding.ActivityMainBinding

class HomeFragment:Fragment() {
    private var _binding: ActivityMainBinding? = null
    private var binding get() = requireNotNull(_binding)

    override fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}