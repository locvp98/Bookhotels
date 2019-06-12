package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bookhotels.R
import com.example.bookhotels.dto.Hotels
import com.example.bookhotels.uiview.detailhotels.DetailHotelsActivity
import com.example.bookhotels.uiview.selective.SelectiveModel
import com.example.bookhotels.uiview.selective.Selectivelistener
import com.example.bookhotels.uiview.selective.SeletiveView
import kotlinx.android.synthetic.main.custum_layoutdiscovery.view.*

class DiscoveryAdapter(var context: Context,var discoverylist:ArrayList<Hotels>):
    androidx.recyclerview.widget.RecyclerView.Adapter<DiscoveryAdapter.DiscoveryViewHodel>(),Selectivelistener {
    override fun danhsachteuthich(danhsachlist: ArrayList<Hotels>) {

    }

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

        p0.imgyeuthich.setOnClickListener(View.OnClickListener {

            Toast.makeText(context,"phong" + hotels.tenphong,Toast.LENGTH_LONG).show()
            val selectivemodel:SelectiveModel=SelectiveModel(context)
            val ho=Hotels()
            ho.tenphong = hotels.tenphong!!
            ho.diachi= hotels.diachi!!
           ho.chitietphong= hotels.chitietphong!!
           ho.maso = hotels.maso!!
            ho.giaphong= hotels.giaphong!!
            ho.image= hotels.image!!
           ho._idhotels= hotels._idhotels!!


            Log.d("giatri",""+ho.toString())

          val kiemtra:Boolean= selectivemodel.themyeuthich(ho)

            if (kiemtra){
                p0.imgyeuthich.visibility=View.GONE
                p0.imgyeuthichs.visibility=View.VISIBLE
//                p0.imgyeuthich.setImageResource(R.drawable.iconlive)
            }
        })
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
        var imgyeuthichs:ImageButton=itemView.imgyeuthichs
        var imgyeuthich:ImageButton=itemView.imgyeuthich
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