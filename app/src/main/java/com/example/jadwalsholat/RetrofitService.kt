package com.example.jadwalsholat

import com.example.jadwalsholat.model.solat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{
    @GET("bandung.json?key=51df7ca86a64638233f46a4059cf8e3f")

    fun getAPI(@Path("city")city:String): retrofit2.Call<solat>

    companion object{
        fun create():RetrofitService{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://muslimsalat.com/")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }

}