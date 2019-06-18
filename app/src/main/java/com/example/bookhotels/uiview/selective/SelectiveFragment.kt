package com.example.bookhotels.uiview.selective

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhotels.R
import com.example.bookhotels.adapter.SeletiveAdapte
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_all_discovery.*
import kotlinx.android.synthetic.main.fragment_selective.*
import kotlinx.android.synthetic.main.fragment_selective.view.*

class SelectiveFragment: androidx.fragment.app.Fragment(),SeletiveView {

   lateinit var selectivePresenter:SelectivePresenter
    lateinit var seletivelist:ArrayList<Hotels>
   lateinit var recycle_selevitess:RecyclerView



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.fragment_selective,container,false)
     recycle_selevitess = view.findViewById(R.id.recycle_selevitess)

        selectivePresenter= SelectivePresenter(this!!.activity!!,this)
        selectivePresenter.danhsachyeuthichd()
        Log.d("DDDDDDTTTTTT", "" +   selectivePresenter.danhsachyeuthichd().toString())


        return view
    }

    @SuppressLint("WrongConstant")
    override fun laydanhsachthanhcong(danhsachlist: ArrayList<Hotels>) {

        seletivelist = ArrayList()
        seletivelist = danhsachlist

        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(activity)
        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
        recycle_selevitess.layoutManager=linearLayoutManager
        var adapter:SeletiveAdapte= SeletiveAdapte(this!!.activity!!,seletivelist)
        adapter.notifyDataSetChanged()
        recycle_selevitess.adapter =adapter

        Log.d("KKKKKKK",""+seletivelist.size)

    }





















































    override fun laydanhsachthatbai() {
        Toast.makeText(activity,"ko co",Toast.LENGTH_LONG).show()
    }

}
