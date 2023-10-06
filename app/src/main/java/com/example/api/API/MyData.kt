package com.example.api.API

import com.example.api.Observer
import com.example.api.View

data class MyData(
    val observer: Observer,
    val style: String,
    val view: View
)