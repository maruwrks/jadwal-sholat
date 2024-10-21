package com.example.jadwalsholat

import android.content.Context
import com.example.jadwalsholat.model.Item
import com.example.jadwalsholat.model.solat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SholatPresenter(context: Context){
    private val sholatView = context as ISholatView

    fun getDataFromAPI(city:String){
        RetrofitService.create()
            .getAPI(city)
            .enqueue(object :Callback<solat> {
                override fun onFailure(call: Call<solat>, t: Throwable) {
                    sholatView.onDataErrorFromAPI(t)
                }

                override fun onResponse(call: Call<solat>, response: Response<solat>) {
                    sholatView.onDataFromAPI(response.body()?.items?.get(0) as Item)
                }
            })
    }
}