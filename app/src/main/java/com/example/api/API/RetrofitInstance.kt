package com.example.api.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun retrofitInstance(): Retrofit {
       return Retrofit.Builder().baseUrl("https://gorest.co.in/public/v2/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    fun cryptoInstance() : Retrofit{
        return Retrofit.Builder().baseUrl("https://crypto-news16.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}