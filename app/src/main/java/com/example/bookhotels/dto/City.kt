package com.example.bookhotels.dto

import com.google.gson.annotations.SerializedName

class City {
    @SerializedName("city")
    var city:String?=null

    @SerializedName("image")
    var image:String?=null

    constructor(city: String?, image: String?) {
        this.city = city
        this.image = image
    }
}