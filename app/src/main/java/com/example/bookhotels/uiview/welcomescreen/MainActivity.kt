package com.example.bookhotels.uiview.welcomescreen

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.bookhotels.R
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time:Timer =Timer()
        time.schedule(timerTask {
            val intent:Intent = Intent(this@MainActivity,HomeNavActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}
