package com.example.bookhotels.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.main.custum_alldiscovery.view.*

class AllDiscoveryHotel(var context: Context, var alldiscoverylist: ArrayList<Hotels>):
    RecyclerView.Adapter<AllDiscoveryHotel.RecycleviewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecycleviewHolder {
        val view:View=LayoutInflater.from(context).inflate(R.layout.custum_alldiscovery,p0,false)

        return RecycleviewHolder(view)
    }

    override fun getItemCount(): Int {
     return alldiscoverylist.size
    }

    override fun onBindViewHolder(p0: RecycleviewHolder, p1: Int) {
        var hotels:Hotels=alldiscoverylist.get(p1)
        p0.tvtenkhachsan.text= hotels.tenphong.toString()
        p0.tvgiaphong.text =hotels.giaphong.toString() + "" + " đ/đêm"
        p0.tvdiachi.text=hotels.diachi
        Glide.with(context)
            .load(hotels.image)
            .into(p0.imganhgoiy)

    }

    class RecycleviewHolder(view:View): RecyclerView.ViewHolder(view) {
        var imganhgoiy:ImageView = view.imganhgoiy
        var tvtenkhachsan:TextView =view.tvtenkhachsan
        var tvgiaphong:TextView= view.tvgiaphong
        var tvdiachi:TextView=view.tvdiachi
    }
}