package com.example.bookhotels.uiview.account

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookhotels.R
import com.example.bookhotels.uiview.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment:Fragment(),View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View =inflater.inflate(R.layout.fragment_account,container,false)
        view.btnnutdangnhap.setOnClickListener(this)
        return view
    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.btnnutdangnhap ->{
               val intent:Intent = Intent(activity,LoginActivity::class.java)
               startActivity(intent)
           }
       }
    }
}