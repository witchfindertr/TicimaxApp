package com.example.ticimaxapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://gorest.co.in/public-api/"
const val FIRST_PAGE = 1
const val FORMAT = "json"
const val PER_PAGE = 20

class RetrofitClient {

    companion object {

        private var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getClient(): RetrofitInterface = retrofit.create(RetrofitInterface::class.java)
    }



}