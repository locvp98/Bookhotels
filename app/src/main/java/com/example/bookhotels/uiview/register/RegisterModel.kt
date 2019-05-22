package com.example.bookhotels.uiview.register

import android.util.Log
import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterModel(val resgisterListener: ResgisterListener){

    fun posdataregister(email:String,password:String,username:String){

        var call:Call<ResponseBody> = Client.getService()!!.postregister(email,password,username)
        call.enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                resgisterListener.loginFale("that bai")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code()==201){
                    resgisterListener.loginSuccess()
                }
            }

        })

    }


}