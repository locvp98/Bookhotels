package com.example.bookhotels.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.AllCity
import com.example.bookhotels.dto.City
import kotlinx.android.synthetic.main.custumlayout_cityadapter.view.*

class DiscoveryCityAdapter(var context:Context,var citylist: ArrayList<AllCity>): RecyclerView.Adapter<DiscoveryCityAdapter.RecycleviewHodel>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecycleviewHodel {
       val view :View =LayoutInflater.from(context).inflate(R.layout.custumlayout_cityadapter,p0,false)
        return RecycleviewHodel(view)
    }

    override fun getItemCount(): Int {
       return citylist.size
    }

    override fun onBindViewHolder(p0: RecycleviewHodel, p1: Int) {
       var city:AllCity=citylist.get(p1)
        p0.tvcity.text=city.city
        Glide.with(context)
            .load(city.image)
            .into(p0.imagcho)


    }

    class RecycleviewHodel(view :View): RecyclerView.ViewHolder(view) {
        var imagcho:ImageView=view.imgecho
        var tvcity:TextView=view.tvcity
        var tvsocho:TextView=view.tvsochoo
    }
}