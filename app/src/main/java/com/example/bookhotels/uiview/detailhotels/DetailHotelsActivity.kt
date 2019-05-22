package com.example.bookhotels.uiview.detailhotels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.bookhotels.R
import com.example.bookhotels.dto.AllCity
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.discover.DiscoveryPresenter
import com.example.bookhotels.uiview.discover.DiscoveryView
import kotlinx.android.synthetic.main.activity_detail_hotels.*

class DetailHotelsActivity : AppCompatActivity(),DiscoveryView {
    override fun demsoluongphong(soluong: Int) {

    }

    companion object {
        var TAG="activity_detail_hotels"
        lateinit var discoveryPresenter:DiscoveryPresenter
        var id:String=""
        lateinit var arrhotels:ArrayList<Hotels>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hotels)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        discoveryPresenter=DiscoveryPresenter(this)
        discoveryPresenter.getCampaignsModel()

        var intent:Intent=intent
         id=intent.getStringExtra("idhotel")
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
    override fun getdatahotels(hotelslist: ArrayList<Hotels>) {
        arrhotels = ArrayList()
        arrhotels=hotelslist
        var tenphong:String=""
        var maso:String=""
        var giatien:String=""
        var diachis:String=""
        var gioithieu:String=""
        var quydinh:String=""

        var idhotelsss:String=""
        for(i in 0 until arrhotels.size){
            var hotels:Hotels=arrhotels.get(i)
             tenphong= hotels.tenphong.toString()
            diachis=hotels.diachi.toString()
            idhotelsss=hotels._idhotels.toString()
            maso=hotels.maso.toString()
            giatien=hotels.giaphong.toString()
            gioithieu=hotels.chitietphong.toString()
            quydinh=hotels.quydinh.toString()

        }
        if(idhotelsss.equals(id)){
            edttenphong.text=tenphong
            edtmacho.text= "Mã số : " + maso
            txtdiachi.text=diachis
            txtgioithieu.text=gioithieu
            txtquydinh.text=quydinh
            txtgiaphong.text=giatien + " đ/đêm"
            Log.d(TAG,tenphong)
        }
    }
    override fun getdatacity(citylist: ArrayList<AllCity>) {

    }



}
