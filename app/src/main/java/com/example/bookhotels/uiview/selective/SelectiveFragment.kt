package com.example.bookhotels.uiview.selective

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhotels.R
import com.example.bookhotels.adapter.SeletiveAdapte
import com.example.bookhotels.dto.Hotels
import kotlinx.android.synthetic.main.fragment_selective.*
class SelectiveFragment: androidx.fragment.app.Fragment(),SeletiveView {

  //  lateinit var selectivePresenter:SelectivePresenter
    lateinit var selectiveModel:SelectiveModel
    lateinit var seletivelist:ArrayList<Hotels>

       var recycle_selevite:RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.fragment_selective,container,false)
//        selectivePresenter= SelectivePresenter(this!!.activity!!,this)
//        selectivePresenter.danhsachyeuthichd()
  //      Log.d("DDDDDDTTTTTT", "" +   selectivePresenter.danhsachyeuthichd().toString())
       // selectiveModel=SelectiveModel(this)
        selectiveModel.laydanhsachyeuthich()
        return view
    }

    override fun laydanhsachthanhcong(danhsachlist: ArrayList<Hotels>) {
//        Log.d("DDDDDD", "" + danhsachlist)
//        seletivelist = ArrayList()
//        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
//        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
//
//        recycle_selevite!!.layoutManager = linearLayoutManager
//        seletivelist = danhsachlist
//
//        var adapter: SeletiveAdapte = SeletiveAdapte(this.activity!!, seletivelist)
//        adapter.notifyDataSetChanged()
//        recycle_selevite!!.adapter = adapter

    }





















































    override fun laydanhsachthatbai() {
        Toast.makeText(activity,"ko co",Toast.LENGTH_LONG).show()
    }

}
