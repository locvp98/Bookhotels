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
import kotlinx.android.synthetic.main.custum_layoutdiscovery.view.*

class DiscoveryAdapter(var context: Context,var discoverylist:ArrayList<Hotels>):
    RecyclerView.Adapter<DiscoveryAdapter.DiscoveryViewHodel>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiscoveryViewHodel {
        val view :View =LayoutInflater.from(context).inflate(R.layout.custum_layoutdiscovery,p0,false)

        return DiscoveryViewHodel(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(p0: DiscoveryViewHodel, p1: Int) {
        var hotels:Hotels =discoverylist.get(p1)
        p0.tvtenks!!.text = hotels.tenphong.toString()
        p0.giaphong!!.text = hotels.giaphong.toString() + " "+" đ/đêm"
        p0.diachi!!.text= hotels.diachi.toString()

        Glide.with(context)
            .load(hotels.image)
            .into( p0.image!!)

    }

    class DiscoveryViewHodel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image:ImageView?=itemView.imganhgoiy
        var tvtenks:TextView?=itemView.tvtenkhachsan
        var giaphong:TextView?=itemView.tvgiaphong
        var diachi:TextView?=itemView.tvdiachi
    }

}