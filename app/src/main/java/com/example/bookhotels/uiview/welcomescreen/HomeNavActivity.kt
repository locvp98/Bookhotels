package com.example.bookhotels.uiview.welcomescreen

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookhotels.R
import com.example.bookhotels.uiview.discover.DiscoverFragment
import com.example.bookhotels.uiview.account.AccountFragment
import com.example.bookhotels.uiview.message.MessageFragment
import com.example.bookhotels.uiview.selective.SelectiveFragment
import kotlinx.android.synthetic.main.activity_home_nav.*

class HomeNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_nav)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.container,DiscoverFragment()).commit()

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.container,DiscoverFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.container,SelectiveFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction().replace(R.id.container,MessageFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_account -> {
                supportFragmentManager.beginTransaction().replace(R.id.container,AccountFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            else ->{
                supportFragmentManager.beginTransaction().replace(R.id.container,AccountFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }


}
