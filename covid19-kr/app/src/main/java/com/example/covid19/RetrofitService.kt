package com.example.covid19

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("covid19/{date}/")
    fun getDateList(
        @Path("date") date: String
    ): Call<Covid>

    @GET("covid19/all/")
    fun getDataList(): Call<ArrayList<Covid>>
}