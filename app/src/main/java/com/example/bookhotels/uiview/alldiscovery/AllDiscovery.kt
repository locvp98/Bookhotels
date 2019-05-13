package com.example.bookhotels.uiview.alldiscovery

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import com.example.bookhotels.R
import com.example.bookhotels.adapter.AllDiscoveryHotel
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.discover.DiscoveryPresenter
import com.example.bookhotels.uiview.discover.DiscoveryView
import com.example.bookhotels.uiview.welcomescreen.HomeNavActivity
import kotlinx.android.synthetic.main.activity_all_discovery.*




class AllDiscovery : AppCompatActivity(),DiscoveryView {
    lateinit var discoveryPresenter: DiscoveryPresenter
    lateinit var hotels: Hotels
    lateinit var allaraylist:ArrayList<Hotels>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.bookhotels.R.layout.activity_all_discovery)
        setSupportActionBar(mToolbar);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);

        discoveryPresenter = DiscoveryPresenter(this)
        discoveryPresenter.getCampaignsModel()

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

    override fun getdatahotels(hotelslist: ArrayList<Hotels>) {
        allaraylist= ArrayList()
        allaraylist=hotelslist

        var linearLayoutManager:LinearLayoutManager = GridLayoutManager(this,2)
        linearLayoutManager.orientation =LinearLayoutManager.VERTICAL
        recycle_alldis.layoutManager=linearLayoutManager
        var adapter:AllDiscoveryHotel= AllDiscoveryHotel(this,hotelslist)
        adapter.notifyDataSetChanged()
        recycle_alldis.adapter =adapter
    }

    override fun getdatacity(citylist: ArrayList<City>) {

    }
}
