package com.example.jadwalsholat.model


import com.google.gson.annotations.SerializedName

data class solat(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("daylight")
    val daylight: String,
    @SerializedName("for")
    val forX: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("map_image")
    val mapImage: String,
    @SerializedName("method")
    val method: Int,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("prayer_method_name")
    val prayerMethodName: String,
    @SerializedName("qibla_direction")
    val qiblaDirection: String,
    @SerializedName("query")
    val query: String,
    @SerializedName("sealevel")
    val sealevel: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_description")
    val statusDescription: String,
    @SerializedName("status_valid")
    val statusValid: Int,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("today_weather")
    val todayWeather: TodayWeather
)