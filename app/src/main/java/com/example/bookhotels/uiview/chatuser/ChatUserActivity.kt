package com.example.bookhotels.uiview.chatuser

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.bookhotels.R
import com.example.bookhotels.adapter.MessageAdapter
import com.example.bookhotels.dto.Messagesuser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chat_user.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

import android.view.inputmethod.InputMethodManager
import android.app.Activity
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.example.bookhotels.comon.Constant
import com.example.bookhotels.uiview.welcomescreen.HomeNavActivity
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*


class ChatUserActivity : AppCompatActivity(), View.OnClickListener, ChatUserView {


    private lateinit var database: DatabaseReference
    lateinit var id: String
    lateinit var _idhientai: String
    lateinit var chatarr: ArrayList<Messagesuser>
    lateinit var chatUserPresenter: ChatUserPresenter
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_user)
        xulytoobal()

        var she: SharedPreferences = this!!.getSharedPreferences("dangnhap", Context.MODE_PRIVATE)
        database = FirebaseDatabase.getInstance().reference
        _idhientai = she.getString("_id", "")

        imgsend.setOnClickListener(this)

        chatUserPresenter = ChatUserPresenter(this)
        chatUserPresenter.getdatachat(_idhientai, id)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.imgsend -> {
                var messa = edt_send.text.toString()
                if (!messa.equals("")) {
                    senMessage(_idhientai, id, messa)
                    edt_send.text.clear()
                    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }
            }

            R.id.imgicon ->{
                checkPermisstion()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun onIsPermisstionNotGranted() {
        //chua dc cap dc cap
        requestPermissions(
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Constant.REQESS_IMAGE
        )
    }

    private fun checkPermisstion() {
        if ((this as HomeNavActivity).hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            openImage()
        } else {
            onIsPermisstionNotGranted()
        }
    }

    fun openImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, Constant.REQESS_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {

            val image = data.data
            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap((this as HomeNavActivity).contentResolver, image)
            var tenfile=persistImage(bitmap).toString()
            val type: String = Constant.IMAGE
            imgalllogo.setImageBitmap(bitmap)
            Toast.makeText(this,"" + tenfile,Toast.LENGTH_SHORT).show()

        }
    }

    private fun persistImage(bitmap: Bitmap): File? {

        val filesDir: File = (this as HomeNavActivity).filesDir
        val currentTime: Date = Calendar.getInstance().time
        val name: String = "$currentTime"
        val imageFile: File = File(filesDir, "$name.jpg")
        val os: OutputStream
        return try {
            os = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
            os.flush()
            os.close()
            imageFile
        } catch (e: Exception) {
            Log.d("LOI", "", e)
            null
        }
    }

    fun xulytoobal(){

        var intent: Intent = getIntent()
        id = intent.getStringExtra("iduser")
        username = intent.getStringExtra("username")
        setSupportActionBar(chat_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        tvnamechat.text = username
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

    fun senMessage(sender: String, userid: String, message: String) {
        var hashmap: HashMap<String, String> = HashMap()
        hashmap.put("sender", sender)
        hashmap.put("userid", userid)
        hashmap.put("message", message)
        database = FirebaseDatabase.getInstance().reference
        database.child("chat").push().setValue(hashmap)
    }

    @SuppressLint("WrongConstant")
    override fun getlistchat(listchat: ArrayList<Messagesuser>) {
        chatarr = ArrayList()
        chatarr = listchat
        var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this@ChatUserActivity)
        linearLayoutManager.orientation = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
        recycle_chatuser.layoutManager = linearLayoutManager
        var adapter: MessageAdapter = MessageAdapter(this@ChatUserActivity, chatarr)
        adapter.notifyDataSetChanged()
        recycle_chatuser.adapter = adapter

    }

}
