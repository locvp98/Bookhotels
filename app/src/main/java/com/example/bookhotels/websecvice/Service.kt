package com.example.bookhotels.websecvice

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("/dataroms")
    fun getdatakhachsan():Call<ResponseBody>

}