package com.example.bookhotels.dto

import com.google.gson.annotations.SerializedName
import java.util.*

class Hotels {

    @SerializedName("_id")
    var _idhotels:String?=null

    @SerializedName("tenphong")
    var tenphong:String ? =null

    @SerializedName("diachi")
    var diachi:String?=null

    @SerializedName("image")
    var image:String?=null

    @SerializedName("giaphong")
    var giaphong:Int?=null

    @SerializedName("maso")
    var maso:Int?=null

    @SerializedName("chitietphong")
    var chitietphong:String?=null

    @SerializedName("quydinh")
    var quydinh:String?=null

    @SerializedName("hotelid")
    var hotelid:List<City>? = null


    constructor(
        _idhotels: String?,
        tenphong: String?,
        diachi: String?,
        image: String?,
        giaphong: Int?,
        maso: Int?,
        chitietphong: String?,
        quydinh: String?,
        hotelid: List<City>?
    ) {
        this._idhotels = _idhotels
        this.tenphong = tenphong
        this.diachi = diachi
        this.image = image
        this.giaphong = giaphong
        this.maso = maso
        this.chitietphong = chitietphong
        this.quydinh = quydinh
        this.hotelid = hotelid
    }


}