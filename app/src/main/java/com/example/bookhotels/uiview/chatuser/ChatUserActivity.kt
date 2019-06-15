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





class ChatUserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var database: DatabaseReference
    lateinit var id:String
    lateinit var _idhientai:String
    lateinit var chatarr:ArrayList<Messagesuser>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_user)

        var intent:Intent=getIntent()
        id = intent.getStringExtra("iduser")
        var username:String = intent.getStringExtra("username")
        var she: SharedPreferences =this!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        Log.d("LLLLLL",""+id.toString())

        database = FirebaseDatabase.getInstance().reference

        _idhientai =she.getString("_id","")
        Toast.makeText(this,"id: " +_idhientai ,Toast.LENGTH_LONG).show()

        setSupportActionBar(chat_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        tvnamechat.text=username
        imgsend.setOnClickListener(this)
        readMessage(_idhientai,id)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.imgsend ->{
                var messa =edt_send.text.toString()
                if (!messa.equals("")){
                    senMessage(_idhientai,id,messa)
                    edt_send.text.clear()
                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }

            }
        }

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

    fun senMessage(sender:String,userid:String,message:String){
        var hashmap: HashMap<String,String> = HashMap()
        hashmap.put("sender",sender)
        hashmap.put("userid",userid)
        hashmap.put("message",message)
        database = FirebaseDatabase.getInstance().reference
        database.child("chat").push().setValue(hashmap)
    }

    fun readMessage(_idhientai:String, ids:String){
        chatarr = ArrayList()

        // database = FirebaseDatabase.getInstance().getReference("chat")

        val childEventListener = object : ChildEventListener {
            @SuppressLint("WrongConstant")
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                    var mes:Messagesuser= dataSnapshot.getValue(Messagesuser::class.java)!!
             //   Log.d("AAAAA",""+mes.sender.toString())
                if (mes.sender.equals(_idhientai) && mes.userid.equals(ids) || mes.sender.equals(ids) && mes.userid.equals(_idhientai)) {
                //    Log.d("AAAAA",""+meidss.message.toString())
                        chatarr.add(mes)
                        Log.d("LLLLLL",""+chatarr.size.toString())
                    }

                var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(this@ChatUserActivity)
                linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
                recycle_chatuser.layoutManager=linearLayoutManager
                var adapter:MessageAdapter =MessageAdapter(this@ChatUserActivity,chatarr)
                adapter.notifyDataSetChanged()
                recycle_chatuser.adapter =adapter



//                Log.d(TAG, "onChildAdded:" + dataSnapshot.key!!)


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
        database.child("chat").addChildEventListener(childEventListener)

    }


}
