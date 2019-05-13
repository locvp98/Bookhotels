package com.example.bookhotels.uiview.discover

import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels

interface Discoverylistenner {
    fun getdatahotels(discoverylist: ArrayList<Hotels>)
    fun getcity(citylist:ArrayList<City>)
}