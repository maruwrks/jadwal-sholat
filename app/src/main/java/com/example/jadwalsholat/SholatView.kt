package com.example.jadwalsholat

import com.example.jadwalsholat.model.Item

interface ISholatView{
    fun onDataFromAPI (salat: Item)
    fun onDataErrorFromAPI(throwable: Throwable)
}