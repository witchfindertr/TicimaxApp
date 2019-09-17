package com.example.ticimaxapp.models


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("code")
    val code: Int,
    @SerializedName("currentPage")
    val currentPage: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("totalCount")
    val totalCount: Int
)