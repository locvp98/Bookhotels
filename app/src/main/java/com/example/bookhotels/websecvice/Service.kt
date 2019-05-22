package com.example.bookhotels.websecvice

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @GET("/dataroms")
    fun getdatakhachsan(): Call<ResponseBody>

    @GET("/datahotels")
    fun getdatathanhpho(): Call<ResponseBody>

    @GET("/datacomment/{hotelid}")
    fun getdatahotelsid(@Path("hotelid") hotelid: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/login")
    fun PostLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/register")
    fun postregister(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<ResponseBody>

}