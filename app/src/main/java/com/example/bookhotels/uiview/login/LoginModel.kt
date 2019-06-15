package com.example.bookhotels.uiview.login

import android.util.Log
import android.widget.Toast
import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel(val loginListener: LoginListener) {

    fun PostdataLogin(email:String,password:String){
        var call:Call<ResponseBody> = Client.getService()!!.PostLogin(email,password)
        call.enqueue(object:Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginListener.loginFale("loi")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful && response.body() != null){

                    var jsonoop:JSONObject= JSONObject(response.body()!!.string())
                    var username:String=jsonoop.get("username").toString()
                    var _id:String=jsonoop.get("_id").toString()
                    Log.d("AAAAA",""+jsonoop)
                    loginListener.loginSuccess(username,_id)

                }else{
                  loginListener.loginFale("loi")
                }

            }
        })
    }
}