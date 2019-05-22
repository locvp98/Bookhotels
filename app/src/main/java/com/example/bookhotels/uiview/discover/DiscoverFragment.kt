package com.example.bookhotels.uiview.discover

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.bookhotels.R
import com.example.bookhotels.adapter.DiscoveryAdapter
import com.example.bookhotels.adapter.DiscoveryCityAdapter
import com.example.bookhotels.dto.AllCity
import com.example.bookhotels.dto.City
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.alldiscovery.AllDiscovery
import kotlinx.android.synthetic.main.fragment_discover.*
import kotlinx.android.synthetic.main.fragment_discover.view.*

class DiscoverFragment : androidx.fragment.app.Fragment(), DiscoveryView, View.OnClickListener{


    private lateinit var discoveryPresenter: DiscoveryPresenter
    private lateinit var discoverilist: ArrayList<Hotels>
    lateinit var thanhpholist:ArrayList<AllCity>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_discover, container, false)
        discoveryPresenter = DiscoveryPresenter(this)
        discoveryPresenter.getCampaignsModel()
        discoveryPresenter.getdatacitytp()
        discoveryPresenter.demsoluong()
//        var relaytivexemthem:RelativeLayout=view.
        view.relaytivexemthem.setOnClickListener(this)
        return view
    }

    override fun getdatahotels(hotelslist: ArrayList<Hotels>) {


        discoverilist = ArrayList()
        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(activity)
        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL

        recyclehotel!!.layoutManager = linearLayoutManager
        discoverilist = hotelslist
        Log.d("DDDDDD", "" + hotelslist)
        var adapter: DiscoveryAdapter = DiscoveryAdapter(this.activity!!, hotelslist)
        adapter.notifyDataSetChanged()
        recyclehotel.adapter = adapter

    }

    override fun getdatacity(citylist: ArrayList<AllCity>) {
        thanhpholist= ArrayList()
        thanhpholist=citylist


        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(activity)
        linearLayoutManager.orientation= androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
        recyclecity.layoutManager=linearLayoutManager
        thanhpholist=citylist

        var adaptercity= DiscoveryCityAdapter(activity!!,citylist)

        adaptercity.notifyDataSetChanged()
        recyclecity.adapter=adaptercity

    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.relaytivexemthem ->{
                val intent:Intent= Intent(activity,AllDiscovery::class.java)
                startActivity(intent)
            }
        }
    }
    override fun demsoluongphong(soluong: Int) {
        Toast.makeText(activity,"soluong"+soluong,Toast.LENGTH_LONG).show()
    }




}