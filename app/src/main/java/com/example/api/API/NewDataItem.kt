package com.example.api.API

data class NewDataItem(
    val due_on: String,
    val id: Int,
    val status: String,
    val title: String,
    val user_id: Int
)