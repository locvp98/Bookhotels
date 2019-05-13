package com.example.bookhotels.uiview.detailhotels

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.main.activity_detail_hotels.*

class DetailHotelsActivity : AppCompatActivity() {
    companion object {
        var TAG="activity_detail_hotels"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hotels)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var intent:Intent=intent
        var id=intent.getStringExtra("idhotel")

        Log.d(TAG,""+id)

        //var hotelsdt:Hotels =


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home->{
                onBackPressed()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
