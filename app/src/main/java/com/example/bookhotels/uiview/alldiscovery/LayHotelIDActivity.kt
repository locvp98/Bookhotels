package com.example.bookhotels.uiview.alldiscovery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.example.bookhotels.R
import com.example.bookhotels.adapter.AllDiscoveryHotel
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.main.activity_all_discovery.*
import kotlinx.android.synthetic.main.activity_lay_hotel_id.*

class LayHotelIDActivity : AppCompatActivity(), Layhotelview {
    lateinit var layHotelidPresenter:LayHotelidPresenter
    lateinit var allaraylist:ArrayList<Hotels>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lay_hotel_id)

        setSupportActionBar(mToolbarid)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var  intent:Intent=intent
        var idtp=intent.getStringExtra("idhotel")

        layHotelidPresenter = LayHotelidPresenter(this)
        layHotelidPresenter.gethotel(idtp)



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
    override fun gethotel(hotelis: ArrayList<Hotels>) {
        allaraylist= ArrayList()
        allaraylist=hotelis
        Log.d("OOOOOO" ,""+allaraylist.size)

        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.GridLayoutManager(this, 2)
        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
        recycle_alldisid.layoutManager=linearLayoutManager
        var adapter: AllDiscoveryHotel = AllDiscoveryHotel(this,hotelis)
        adapter.notifyDataSetChanged()
        recycle_alldisid.adapter =adapter
    }
}
