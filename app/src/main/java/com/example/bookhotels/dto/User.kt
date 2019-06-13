package com.example.bookhotels.dto

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    var id:String?=null

    @SerializedName("email")
    var email:String?=null

    @SerializedName("username")
    var username:String?=null

    constructor(id: String?, email: String?, username: String?) {
        this.id = id
        this.email = email
        this.username = username
    }
}