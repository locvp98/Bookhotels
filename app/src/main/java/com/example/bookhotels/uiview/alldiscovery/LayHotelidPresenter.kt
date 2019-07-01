package com.example.bookhotels.uiview.alldiscovery

import com.example.bookhotels.dto.Hotels

class LayHotelidPresenter(var layhotelview: Layhotelview):LayHotelListener {

  private val layHotelModel =LayHotelModel(this)

    fun gethotel(idhotel:String){
        layHotelModel.getdatahotel(idhotel)
    }

    override fun getdatahotel(hotellist: ArrayList<Hotels>) {
       layhotelview.gethotel(hotellist)

    }
}