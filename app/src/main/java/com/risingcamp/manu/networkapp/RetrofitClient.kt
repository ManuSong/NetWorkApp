package com.risingcamp.manu.networkapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val sRetrofit = initRetrofit()
    private const val RESTUARENT_URL = "https://api.odcloud.kr/api/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(RESTUARENT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}