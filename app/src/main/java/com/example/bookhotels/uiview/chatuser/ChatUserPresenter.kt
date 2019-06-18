package com.example.bookhotels.uiview.chatuser

import com.example.bookhotels.dto.Messagesuser

class ChatUserPresenter(var chatUserView: ChatUserView):ChatUserListener {

    var chatUserModel = ChatUserModel(this)
    lateinit var listdatachat:ArrayList<Messagesuser>


    fun getdatachat(_idhientai:String, ids:String){
        chatUserModel.readMessage(_idhientai,ids)
    }

    override fun getlistchat(listchat: ArrayList<Messagesuser>) {
        listdatachat= ArrayList()
        listdatachat=listchat
        chatUserView.getlistchat(listdatachat)
    }



}