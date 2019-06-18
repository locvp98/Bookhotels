package com.example.bookhotels.uiview.chatuser

import android.annotation.SuppressLint
import android.util.Log
import com.example.bookhotels.dto.Messagesuser
import com.google.firebase.database.*

class ChatUserModel(var chatUserListener: ChatUserListener) {

    lateinit var chatarr:ArrayList<Messagesuser>
    private val reference: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun readMessage(_idhientai:String, ids:String){
        chatarr=ArrayList()
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                var mes: Messagesuser = dataSnapshot.getValue(Messagesuser::class.java)!!
                if (mes.sender.equals(_idhientai) && mes.userid.equals(ids) || mes.sender.equals(ids) && mes.userid.equals(_idhientai)) {
                    chatarr.add(mes)
                    chatUserListener.getlistchat(chatarr)
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {

            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        reference.child("chat").addChildEventListener(childEventListener)

    }

}