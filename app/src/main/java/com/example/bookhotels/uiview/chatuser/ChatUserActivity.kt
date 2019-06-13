package com.example.bookhotels.uiview.chatuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.bookhotels.R
import kotlinx.android.synthetic.main.activity_chat_user.*
import kotlinx.android.synthetic.main.activity_detail_hotels.*

class ChatUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_user)

        var intent:Intent=getIntent()
        var id:String = intent.getStringExtra("iduser")
        var username:String = intent.getStringExtra("username")

        setSupportActionBar(chat_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        tvnamechat.text=username


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
}
