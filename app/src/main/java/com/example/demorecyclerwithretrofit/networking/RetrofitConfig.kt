package com.example.demorecyclerwithretrofit.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitConfig {

    private lateinit var retrofit:Retrofit

    private val okkHttpClient = OkHttpClient.Builder()
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .connectTimeout(30,TimeUnit.SECONDS)
        .build()

    fun instanceClient():Retrofit{
         retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(okkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}