package com.monica.ec3_monica_gonzales_.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrogitHelper {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://nekos.best/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val listService : ListService = retrofit.create(ListService::class.java)
}