package com.example.bookhotels.uiview.message

import com.example.bookhotels.dto.User

class MessagePresenter(val messageView: MessageView):MessageListener {

    val messageModel =MessageModel(this)

    fun dataUser(){
        messageModel.datachat()
    }

    override fun listuser(datalist: ArrayList<User>) {
        var listuser:ArrayList<User> = ArrayList()
        listuser=datalist
        if (listuser.size>0){
            messageView.listuser(listuser)
        }
    }
}