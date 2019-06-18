package com.example.bookhotels.uiview.chatuser

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.bookhotels.R
import com.example.bookhotels.adapter.MessageAdapter
import com.example.bookhotels.dto.Messagesuser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chat_user.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

import android.view.inputmethod.InputMethodManager
import android.app.Activity


class ChatUserActivity : AppCompatActivity(), View.OnClickListener, ChatUserView {


    private lateinit var database: DatabaseReference
    lateinit var id: String
    lateinit var _idhientai: String
    lateinit var chatarr: ArrayList<Messagesuser>
    lateinit var chatUserPresenter: ChatUserPresenter
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_user)
        xulytoobal()

        var she: SharedPreferences = this!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        database = FirebaseDatabase.getInstance().reference
        _idhientai = she.getString("_id", "")

        imgsend.setOnClickListener(this)

        chatUserPresenter = ChatUserPresenter(this)
        chatUserPresenter.getdatachat(_idhientai, id)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.imgsend -> {
                var messa = edt_send.text.toString()
                if (!messa.equals("")) {
                    senMessage(_idhientai, id, messa)
                    edt_send.text.clear()
                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }
            }
        }
    }

    fun xulytoobal(){

        var intent: Intent = getIntent()
        id = intent.getStringExtra("iduser")
        username = intent.getStringExtra("username")
        setSupportActionBar(chat_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        tvnamechat.text = username
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun senMessage(sender: String, userid: String, message: String) {
        var hashmap: HashMap<String, String> = HashMap()
        hashmap.put("sender", sender)
        hashmap.put("userid", userid)
        hashmap.put("message", message)
        database = FirebaseDatabase.getInstance().reference
        database.child("chat").push().setValue(hashmap)
    }

    @SuppressLint("WrongConstant")
    override fun getlistchat(listchat: ArrayList<Messagesuser>) {
        chatarr = ArrayList()
        chatarr = listchat
        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this@ChatUserActivity)
        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
        recycle_chatuser.layoutManager = linearLayoutManager
        var adapter: MessageAdapter = MessageAdapter(this@ChatUserActivity, chatarr)
        adapter.notifyDataSetChanged()
        recycle_chatuser.adapter = adapter
    }

}
