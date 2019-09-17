package com.example.ticimaxapp.models


import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("_meta")
    val meta: Meta,
    @SerializedName("result")
    val result: List<Result>
)