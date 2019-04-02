package com.example.demorecyclerwithretrofit.networking

import com.example.demorecyclerwithretrofit.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface CallService {

    @GET("/posts")
    fun getAllPost():Call<List<Post>>
}