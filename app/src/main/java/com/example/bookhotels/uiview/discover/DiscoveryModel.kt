package com.example.bookhotels.uiview.discover

import android.util.Log
import com.example.bookhotels.comon.Constant
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.websecvice.Client
import com.example.bookhotels.websecvice.Service
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class DiscoveryModel(val discoverylistenner: Discoverylistenner) {
    companion object {
        var TAG = "DiscoveryModel"
        lateinit var discoverylist: ArrayList<Hotels>
        lateinit var thanhpholist:ArrayList<City>
    }

    fun getDiscoveryHotel() {

        discoverylist= ArrayList()
        thanhpholist= ArrayList();
        val call: Call<ResponseBody> = Client.getService()!!.getdatakhachsan()
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                var jsonarr: JSONArray = JSONArray(response.body()!!.string())
                for (i in 0 until jsonarr.length()) {
                    var objjson: JSONObject = jsonarr.getJSONObject(i)

                    val tenphong = objjson.getString("tenphong")
                    val diachi = objjson.getString("diachi")
                    val image = Constant.BASE_URL + "" + objjson.getString("image")
                    val giaphong = objjson.getInt("giaphong")
                    val maso = objjson.getInt("maso")
                    val chitietphong = objjson.getString("chitietphong")
                    val quydinh = objjson.getString("quydinh")
                    try {
                        var jsonhotelsid: JSONObject = objjson.getJSONObject("hotelid")
                        val city = jsonhotelsid.getString("city")
                        val hinhanh = Constant.BASE_URL + "" + jsonhotelsid.getString("image")
                        var citydto:City = City(city,hinhanh)
                            thanhpholist.add(citydto)

                        Log.d(TAG,"" + hinhanh)
                    } catch (ignored:Exception){}

                    var hotels: Hotels = Hotels(tenphong, diachi, image,giaphong,maso,chitietphong,quydinh)
                    discoverylist.add(hotels)
                    discoverylistenner.getdatahotels(discoverylist)
                    discoverylistenner.getcity(thanhpholist)

                }
            }
        })



    }

    fun getcity(){

    }
}