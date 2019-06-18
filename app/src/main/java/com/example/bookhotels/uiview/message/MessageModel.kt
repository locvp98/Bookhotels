package com.example.bookhotels.uiview.message

import com.example.bookhotels.dto.User
import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MessageModel(val messageListener: MessageListener){


    companion object {
        var user: User? = null
    }

    fun datachat(){
        val call:Call<ResponseBody> = Client.getService()!!.getdatauser()
        call.enqueue(object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                var lisuser:ArrayList<User> = ArrayList()
                var jsonarr: JSONArray = JSONArray(response.body()!!.string())
                for (i in 0 until jsonarr.length()) {
                    var objjson: JSONObject = jsonarr.getJSONObject(i)

                    val iduser  = objjson.getString("_id")
                    val email = objjson.getString("email")
                    val username = objjson.getString("username")
                    user= User(iduser,email,username)
                    lisuser.add(user!!)
                    messageListener.listuser(lisuser)
                }
            }
        })
    }

}