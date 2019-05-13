package com.example.bookhotels.websecvice

import com.example.bookhotels.comon.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client {

    companion object {
        private var service: Service? = null
        fun getService(): Service? {
            if (service == null) {
                Client()//de khoi tao sevice
            }
            return service
        }
    }

    init {

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)//quy dinh thoi gian client conect den server,qua thoi gian la huy
            .readTimeout(10, TimeUnit.SECONDS)//thoi gian cho du lieu ve

        val builder = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL) //chi dinh phan dau api la gi
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create()) //dung gson
        service = builder.build().create(Service::class.java)
    }


}