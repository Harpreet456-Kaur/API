package com.example.api.API

import com.example.api.models.CryptoNewsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APInterface {

    @GET("todos")
    @Headers(
        "",
        "Auth:"
    )
    fun getData() : Call<NewData>

    @GET("news/top/45")
    fun getCrypto() : Call<CryptoNewsItem>
}