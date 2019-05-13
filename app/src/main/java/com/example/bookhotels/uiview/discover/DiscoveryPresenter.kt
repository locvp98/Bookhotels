package com.example.bookhotels.uiview.discover

import android.util.Log
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels

class DiscoveryPresenter(val discoveryView: DiscoveryView):Discoverylistenner{


    private val discoveryModel = DiscoveryModel(this)

    fun getCampaignsModel() {
        discoveryModel.getDiscoveryHotel()
    }

    override fun getdatahotels(discoverylist: ArrayList<Hotels>) {
            discoveryView.getdatahotels(discoverylist)
        }

    override fun getcity(citylist: ArrayList<City>) {
        discoveryView.getdatacity(citylist)
    }
    }





