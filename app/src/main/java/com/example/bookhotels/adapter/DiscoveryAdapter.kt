package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.detailhotels.DetailHotelsActivity
import com.example.bookhotels.uiview.discover.DiscoverFragment
import com.example.bookhotels.uiview.login.LoginActivity
import com.example.bookhotels.uiview.welcomescreen.HomeNavActivity
import kotlinx.android.synthetic.main.custum_layoutdiscovery.view.*

class DiscoveryAdapter(var context: Context,var discoverylist:ArrayList<Hotels>):
    androidx.recyclerview.widget.RecyclerView.Adapter<DiscoveryAdapter.DiscoveryViewHodel>() {

   companion object {
       var idhotels:String=""


    }

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

        p0.setdata(hotels,p1)

    }

    class DiscoveryViewHodel(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

            var hotelis:Hotels?=null
            var postpo:Int=0
        init {

            itemView.setOnClickListener {
                             var intent:Intent= Intent(itemView.context,DetailHotelsActivity::class.java)
                intent.putExtra("idhotel", hotelis!!._idhotels)
                itemView.context.startActivity(intent)
                Toast.makeText(itemView.context,"id ne "+ hotelis!!._idhotels,Toast.LENGTH_LONG).show()

            }
        }

        var image:ImageView?=itemView.imganhgoiy
        var tvtenks:TextView?=itemView.tvtenkhachsan
        var giaphong:TextView?=itemView.tvgiaphong
        var diachi:TextView?=itemView.tvdiachi

        fun setdata(hotel:Hotels?,pos:Int){
            this.hotelis=hotel
            this.postpo= pos
        }
    }



}