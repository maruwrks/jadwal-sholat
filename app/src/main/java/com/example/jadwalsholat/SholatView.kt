package com.example.jadwalsholat

import com.example.jadwalsholat.model.Item

interface ISholatView{
    fun onDataFromAPI (solat: Item)
    fun onDataErrorFromAPI(throwable: Throwable)
}