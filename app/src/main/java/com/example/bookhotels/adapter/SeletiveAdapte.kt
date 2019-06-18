package com.example.bookhotels.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.main.custum_layoutdiscovery.view.*

class SeletiveAdapte(var context: Context, var danhsachlist: ArrayList<Hotels>): androidx.recyclerview.widget.RecyclerView.Adapter<SeletiveAdapte.RecycleviewHodel>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleviewHodel {
        val view :View = LayoutInflater.from(context).inflate(R.layout.custum_layoutselevite,parent,false)
        return RecycleviewHodel(view)    }

    override fun getItemCount(): Int {
            return danhsachlist.size
        }

    override fun onBindViewHolder(holder: RecycleviewHodel, position: Int) {
        var hotels:Hotels = danhsachlist.get(position)

        holder.tvtenks!!.text = hotels.tenphong.toString()
        holder.giaphong!!.text = hotels.giaphong.toString() + " "+" đ/đêm"
        holder.diachi!!.text= hotels.diachi.toString()

        Glide.with(context)
            .load(hotels.image)
            .into( holder.image!!)
  }


    class RecycleviewHodel(view: View):androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var imgyeuthichs: ImageButton =itemView.imgyeuthichs
        var imgyeuthich: ImageButton =itemView.imgyeuthich
        var image: ImageView?=itemView.imganhgoiy
        var tvtenks: TextView?=itemView.tvtenkhachsan
        var giaphong: TextView?=itemView.tvgiaphong
        var diachi: TextView?=itemView.tvdiachi
    }
}