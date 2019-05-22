package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.detailhotels.DetailHotelsActivity
import kotlinx.android.synthetic.main.custum_alldiscovery.view.*

class AllDiscoveryHotel(var context: Context, var alldiscoverylist: ArrayList<Hotels>):
    androidx.recyclerview.widget.RecyclerView.Adapter<AllDiscoveryHotel.RecycleviewHolder>() {
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

        p0.setdata(hotels,p1)

    }

    class RecycleviewHolder(view:View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        var hotelis:Hotels?=null
        var pos:Int=0

        init{
            itemView.setOnClickListener {
                var intent:Intent= Intent(itemView.context,DetailHotelsActivity::class.java)
                intent.putExtra("idhotel",hotelis!!._idhotels)
                itemView.context.startActivity(intent)
            }
        }

        var imganhgoiy:ImageView = view.imganhgoiy
        var tvtenkhachsan:TextView =view.tvtenkhachsan
        var tvgiaphong:TextView= view.tvgiaphong
        var tvdiachi:TextView=view.tvdiachi

        fun setdata(hotels: Hotels,pos:Int){
            this.hotelis=hotels
            this.pos=pos
        }
    }
}