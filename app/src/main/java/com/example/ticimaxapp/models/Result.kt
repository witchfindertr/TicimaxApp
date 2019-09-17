package com.example.ticimaxapp.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("album_id")
    val albumId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)