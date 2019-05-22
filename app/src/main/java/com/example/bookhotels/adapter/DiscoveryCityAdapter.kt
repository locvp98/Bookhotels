package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
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
import com.example.bookhotels.uiview.alldiscovery.LayHotelIDActivity
import kotlinx.android.synthetic.main.custumlayout_cityadapter.view.*

class DiscoveryCityAdapter(var context:Context,var citylist: ArrayList<AllCity>): androidx.recyclerview.widget.RecyclerView.Adapter<DiscoveryCityAdapter.RecycleviewHodel>() {

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

        p0.setdata(city,p1)

    }

    class RecycleviewHodel(view :View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        var city:AllCity?=null
        var postpo:Int=0
        init {

            itemView.setOnClickListener {
                var intent: Intent = Intent(itemView.context, LayHotelIDActivity::class.java)
                intent.putExtra("idhotel", city!!.idtp)
                itemView.context.startActivity(intent)
                //   Toast.makeText(itemView.context,"id ne "+ hotelis!!._idhotels,Toast.LENGTH_LONG).show()

            }
        }

        var imagcho:ImageView=view.imgecho
        var tvcity:TextView=view.tvcity
        var tvsocho:TextView=view.tvsochoo

            fun setdata(city:AllCity?,pos:Int){
                this.city=city
                this.postpo= pos
            }
    }
}