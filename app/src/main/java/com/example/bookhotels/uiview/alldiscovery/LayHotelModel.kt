package com.example.bookhotels.uiview.alldiscovery

import com.example.bookhotels.comon.Constant
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.websecvice.Client
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LayHotelModel(var layHotelListener: LayHotelListener){
    companion object{
        lateinit var hotellist:ArrayList<Hotels>
    }

    fun getdatahotel(hotelid:String){
        val call:Call<ResponseBody> = Client.getService()!!.getdatahotelsid(hotelid)
        call.enqueue(object :Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                hotellist= ArrayList()
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

                    var hotels:Hotels=Hotels(idhotels,tenphong,diachi,image,giaphong,maso,chitietphong,quydinh)
                    hotellist.add(hotels)
                    layHotelListener.getdatahotel(hotellist)

                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

        })
    }

}