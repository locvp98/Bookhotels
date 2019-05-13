package com.example.bookhotels.uiview.discover

import android.util.Log
import com.example.bookhotels.comon.Constant
import com.example.bookhotels.dto.AllCity
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
        lateinit var listallcity:ArrayList<AllCity>
        var city = ""
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
                var jsonhotelsid: JSONObject
                for (i in 0 until jsonarr.length()) {
                    var objjson: JSONObject = jsonarr.getJSONObject(i)

                    val idhotels = objjson.getString("_id")
                    val tenphong = objjson.getString("tenphong")
                    val diachi = objjson.getString("diachi")
                    val image = Constant.BASE_URL + "" + objjson.getString("image")
                    val giaphong = objjson.getInt("giaphong")
                    val maso = objjson.getInt("maso")
                    val chitietphong = objjson.getString("chitietphong")
                    val quydinh = objjson.getString("quydinh")
                    try {
                         jsonhotelsid = objjson.getJSONObject("hotelid")
                        val idcity = jsonhotelsid.getString("_id")
                         city = jsonhotelsid.getString("city")
                        val hinhanh = Constant.BASE_URL + "" + jsonhotelsid.getString("image")
                        var citydto:City = City(city,hinhanh)
                            thanhpholist.add(citydto)

                   //    Log.d(TAG,"" + sum)
                    } catch (ignored:Exception){}
                    var hotels:Hotels= Hotels(idhotels,tenphong,diachi,image,giaphong,maso,chitietphong,quydinh,thanhpholist)

                    discoverylist.add(hotels)
                    discoverylistenner.getdatahotels(discoverylist)

                }


            }
        })

    }

    fun getdataCity(){


      val call:Call<ResponseBody> =Client.getService()!!.getdatathanhpho()
        call.enqueue( object :Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                var Jsonciarr:JSONArray = JSONArray(response.body()!!.string())
                listallcity=ArrayList()

                for (i in 0 until Jsonciarr.length()){

                    var jsonobb:JSONObject=Jsonciarr.getJSONObject(i)
                    val idcity = jsonobb.getString("_id")
                   val tpcity = jsonobb.getString("city")
                    val hinhanh = Constant.BASE_URL + "" + jsonobb.getString("image")
                    var allcitydto:AllCity = AllCity(idcity,tpcity,hinhanh)
                    listallcity.add(allcitydto)
                    discoverylistenner.getcity(listallcity)

                }
            }


        })


    }

}
