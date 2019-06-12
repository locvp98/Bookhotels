package com.example.bookhotels.uiview.detailhotels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.bookhotels.R
import com.example.bookhotels.dto.AllCity
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.ThanhToanActivity
import com.example.bookhotels.uiview.discover.DiscoveryPresenter
import com.example.bookhotels.uiview.discover.DiscoveryView
import com.example.bookhotels.uiview.login.LoginActivity
import kotlinx.android.synthetic.main.activity_detail_hotels.*

class DetailHotelsActivity : AppCompatActivity(),DiscoveryView, View.OnClickListener {


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
        btndatphong.setOnClickListener(this)

        //var hotelsdt:Hotels =


    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.btndatphong ->{
               var sreef :SharedPreferences = this.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
               var tenkh:String?=sreef.getString("tenkh","")
               if (tenkh!!.length>0){
                   val intent = Intent(this@DetailHotelsActivity,ThanhToanActivity::class.java)
                   startActivity(intent)
               }else{
                   val intent = Intent(this@DetailHotelsActivity,LoginActivity::class.java)
                   startActivity(intent)
               }
           }
       }
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
            edtmacho.text="" + R.string.maso + ""+ maso
            txtdiachi.text=diachis
            txtgioithieu.text=gioithieu
            txtquydinh.text=quydinh
            txtgiaphong.text=giatien + ""+ R.string.gia
            Log.d(TAG,tenphong)
        }
    }
    override fun getdatacity(citylist: ArrayList<AllCity>) {

    }



}
