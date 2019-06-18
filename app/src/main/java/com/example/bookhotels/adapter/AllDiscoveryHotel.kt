package com.example.bookhotels.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
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
import com.example.bookhotels.uiview.selective.SelectiveModel
import kotlinx.android.synthetic.main.custum_alldiscovery.view.*

class AllDiscoveryHotel(var context: Context, var alldiscoverylist: ArrayList<Hotels>):
    androidx.recyclerview.widget.RecyclerView.Adapter<AllDiscoveryHotel.RecycleviewHolder>() {

    var selectiveModel = SelectiveModel(context)
    var seletilist:ArrayList<Hotels> = ArrayList()
    var id:String=""

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



        seletilist= ArrayList()
        seletilist =selectiveModel.laydanhsachyeuthich()
        Log.d("ADADADAD",""+seletilist.size)
        if (seletilist.size>0){

            for (i in 0 until seletilist.size){
                var  selehotel:Hotels  = seletilist.get(i)
                id=selehotel._idhotels.toString()
                if (hotels._idhotels.equals(id)){
                    p0.imghinhyeutich.visibility=View.GONE
                    p0.imghinhyeutichsss.visibility=View.VISIBLE
                }
            }
        }

        p0.imghinhyeutich.setOnClickListener {
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
                p0.imghinhyeutich.visibility=View.GONE
                p0.imghinhyeutichsss.visibility=View.VISIBLE
//                p0.imgyeuthich.setImageResource(R.drawable.iconlive)
            }

        }

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

        var imghinhyeutich:ImageView = view.img_hinhyeuthich
        var imghinhyeutichsss:ImageView = view.img_hinhyeuthichss
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