package com.example.bookhotels.dto

import com.google.gson.annotations.SerializedName

class AllCity{
    @SerializedName("_id")
    var idtp:String?=null

    @SerializedName("city")
    var city:String?=null

    @SerializedName("image")
    var image:String?=null

    constructor(idtp: String?, city: String?, image: String?) {
        this.idtp = idtp
        this.city = city
        this.image = image
    }
}