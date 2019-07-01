package com.example.bookhotels.uiview.discover

import android.util.Log
import com.example.bookhotels.dto.AllCity
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels

class DiscoveryPresenter(val discoveryView: DiscoveryView):Discoverylistenner{

    lateinit var arrayhotel:ArrayList<Hotels>

    override fun demsoluongphong(soluong: Int) {
        discoveryView.demsoluongphong(soluong)
    }

    private val discoveryModel = DiscoveryModel(this)

    fun demsoluong(){
        discoveryModel.demsoluong()
    }

    fun getCampaignsModel() {
        discoveryModel.getDiscoveryHotel()
    }
    fun getdatacitytp(){
        discoveryModel.getdataCity()
    }

    override fun getdatahotels(discoverylist: ArrayList<Hotels>) {
        arrayhotel = ArrayList()
        arrayhotel = discoverylist
        if (arrayhotel.size>0){
            Log.d("rrrrr",""+discoverylist.size)
            discoveryView.getdatahotels(discoverylist)
        }
        }

    override fun getcity(citylist: ArrayList<AllCity>) {
        discoveryView.getdatacity(citylist)
    }

    }





