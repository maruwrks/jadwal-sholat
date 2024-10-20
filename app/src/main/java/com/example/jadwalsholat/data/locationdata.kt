package com.example.jadwalsholat.data

sealed class locationdata

data class currentLocation(
    val date: String,
    val location: String = "Pilih Lokasi Terkini"
):locationdata()