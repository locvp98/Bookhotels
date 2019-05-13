package com.example.bookhotels.uiview.discover

import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels

interface DiscoveryView {

    fun getdatahotels(hotelslist:ArrayList<Hotels>)
    fun getdatacity(citylist:ArrayList<City>)
}