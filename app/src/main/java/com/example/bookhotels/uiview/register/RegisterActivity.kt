package com.example.bookhotels.uiview.register

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bookhotels.R
import com.example.bookhotels.uiview.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(),View.OnClickListener,RegisterView {

lateinit var registerPresenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(restablayout)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        registerPresenter= RegisterPresenter(this)
        btnregister.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home ->{
                onBackPressed()
                return  true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }


    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnregister->{
                var hovaten=edthovaten.text.toString()
                var  email= edtemail.text.toString()
                var mk=edtdkmatkhau.text.toString()
                var laimk=edmatkhaudangnhap.text.toString()

                if (mk.equals(laimk) && mk.length>6 && laimk.length>6){
                    registerPresenter.postdata(email,mk,hovaten)
                }


            }
        }

    }

    override fun loginSuccess() {

        var inten=Intent(this,LoginActivity::class.java)
        startActivity(inten)
        finish()

    }

    override fun loginFale(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}
