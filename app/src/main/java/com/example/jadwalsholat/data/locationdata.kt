package com.example.jadwalsholat.data

sealed class locationdata

data class currentLocation(
    val data: String,
    val location: String = "Pilih Lokasi Terkini"
):locationdata()