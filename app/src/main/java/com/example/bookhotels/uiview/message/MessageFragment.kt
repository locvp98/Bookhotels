package com.example.bookhotels.uiview.message

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookhotels.R
import com.example.bookhotels.adapter.UserAdapter
import com.example.bookhotels.dto.User
import kotlinx.android.synthetic.main.fragment_message.*

class MessageFragment : androidx.fragment.app.Fragment(), View.OnClickListener, MessageView {
    lateinit var lisuser: ArrayList<User>
    lateinit var messagepresenter: MessagePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_message, container, false)
        messagepresenter = MessagePresenter(this)
        messagepresenter.dataUser()

        return view
    }

    override fun onClick(p0: View?) {

    }

    override fun listuser(datalist: ArrayList<User>) {

        var she: SharedPreferences =activity!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        var tenkh:String?=she.getString("tenkh","")
        if (tenkh!!.length>0){
            lisuser = ArrayList()

            var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(activity)
            linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL

            recycle_chat!!.layoutManager = linearLayoutManager
            lisuser = datalist
            // Log.d("DDDDDD", "" + hotelslist)
            var adapter: UserAdapter = UserAdapter(this.activity!!, datalist)
            adapter.notifyDataSetChanged()
            recycle_chat.adapter = adapter
        }
        else{
            txtmoidangnhap.visibility = View.VISIBLE
        }


    }
}