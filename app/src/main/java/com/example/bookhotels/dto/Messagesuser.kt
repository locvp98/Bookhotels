package com.example.bookhotels.dto

class Messagesuser {
    var sender:String?=null
    var userid:String?=null
    var message:String?=null

    constructor()

    constructor(sender: String?, userid: String?, message: String?) {
        this.sender = sender
        this.userid = userid
        this.message = message
    }


}