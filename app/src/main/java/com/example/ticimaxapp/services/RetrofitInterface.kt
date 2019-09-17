package com.example.ticimaxapp.services

import com.example.ticimaxapp.models.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("photos")
    fun getPhotos(@Query("_format") format : String,
                        @Query("access-token") apiKey : String,
                        @Query("page") page : Int) : Call<PhotoResponse>
}