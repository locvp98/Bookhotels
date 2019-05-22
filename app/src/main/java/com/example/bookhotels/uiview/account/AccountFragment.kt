package com.example.bookhotels.uiview.account

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookhotels.R
import com.example.bookhotels.uiview.login.LoginActivity
import com.example.bookhotels.uiview.register.RegisterActivity
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment: androidx.fragment.app.Fragment(),View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View =inflater.inflate(R.layout.fragment_account,container,false)
        view.btnnutdangnhap.setOnClickListener(this)
        view.btnnutdangki.setOnClickListener(this)
        view.tvdangxuat.setOnClickListener(this)

        var she: SharedPreferences =activity!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
         var tenkh:String?=she.getString("tenkh","")

        if (tenkh!!.length>0){
            view.lldangnhap1.visibility= View.GONE
            view.lldangnhap2.visibility=View.VISIBLE
            view.tvten.text=tenkh
        }
        else{
            view.lldangnhap1.visibility= View.VISIBLE
            view.lldangnhap2.visibility=View.GONE
            view.tvten.text=tenkh
        }

        return view
    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.btnnutdangnhap ->{
               val intent:Intent = Intent(activity,LoginActivity::class.java)
               startActivity(intent)
           }
           R.id.btnnutdangki ->{
               val intent:Intent= Intent(activity,RegisterActivity::class.java)
               startActivity(intent)
           }
           R.id.tvdangxuat ->{

               showNewNameDialog()



           }
       }
    }

    fun showNewNameDialog() {
        val dialogBuilder = AlertDialog.Builder(activity)

        dialogBuilder.setMessage("bạn có muốn đăng xuất?")
        dialogBuilder.setPositiveButton("có", { dialog, whichButton ->

            var she:SharedPreferences =activity!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor =she.edit()
            editor.remove("tenkh")
            editor.commit()

            var tenkh:String?=she.getString("tenkh","")

            if (tenkh!!.length>0){
                lldangnhap1.visibility= View.GONE
                lldangnhap2.visibility=View.VISIBLE
                tvten.text=tenkh
            }
            else{
                lldangnhap1.visibility= View.VISIBLE
                lldangnhap2.visibility=View.GONE
                tvten.text=tenkh
            }
        })
        dialogBuilder.setNegativeButton("Cancel", { dialog, whichButton ->

        })
        val b = dialogBuilder.create()
        b.show()
    }
}