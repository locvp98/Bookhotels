package com.example.bookhotels.uiview.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.bookhotels.R
import com.example.bookhotels.uiview.account.AccountFragment
import com.example.bookhotels.uiview.welcomescreen.HomeNavActivity
import kotlinx.android.synthetic.main.activity_all_discovery.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener,LoginView {


    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(mtoolbarlg);
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);

        loginPresenter= LoginPresenter(this)
        btndangnhap.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           R.id.btndangnhap ->{
              var email=edemaildangnhap.text.toString()
               var mk=edmatkhaudangnhap.text.toString()
               loginPresenter.login(email,mk)

           }
       }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun loginSuccess(name:String) {
        var she: SharedPreferences = application.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = she.edit()
        editor.putString("tenkh", name)
        val fragment = AccountFragment()
        val intent = Intent(this, HomeNavActivity::class.java)
//        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
        startActivity(intent)

        Toast.makeText(this, "thanh cong" + name, Toast.LENGTH_LONG).show()
        editor.commit()
        //  onBackPressed()
    }
    override fun loginfell() {
        Toast.makeText(this,"bai",Toast.LENGTH_LONG).show()

    }

}
