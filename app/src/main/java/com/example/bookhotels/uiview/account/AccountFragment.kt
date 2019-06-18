package com.example.bookhotels.uiview.account

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.bookhotels.R
import com.example.bookhotels.comon.Constant
import com.example.bookhotels.uiview.language.LanguageActivity
import com.example.bookhotels.uiview.login.LoginActivity
import com.example.bookhotels.uiview.register.RegisterActivity
import com.example.bookhotels.uiview.welcomescreen.HomeNavActivity
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class AccountFragment: androidx.fragment.app.Fragment(),View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View =inflater.inflate(R.layout.fragment_account,container,false)

        view.btnnutdangnhap.setOnClickListener(this)
        view.btnnutdangki.setOnClickListener(this)
        view.tvdangxuat.setOnClickListener(this)
        view.tvcaidat.setOnClickListener(this)
        view.imgupdatelogo.setOnClickListener(this)

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
              onDetach()

           }
           R.id.btnnutdangki ->{
               val intent:Intent= Intent(activity,RegisterActivity::class.java)
               startActivity(intent)
           }
           R.id.tvdangxuat ->{
               showNewNameDialog()
           }
           R.id.tvcaidat ->{
               val intent:Intent = Intent(activity,LanguageActivity::class.java)
               startActivity(intent)
           }

           R.id.imgupdatelogo ->{
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
        if ((activity as HomeNavActivity).hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            openImage()
        } else {
            onIsPermisstionNotGranted()
        }
    }

    private fun openImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, Constant.REQESS_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val image = data.data
            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap((activity as HomeNavActivity).contentResolver, image)
           var tenfile=persistImage(bitmap).toString()
            val type: String = Constant.IMAGE
            imgalllogo.setImageBitmap(bitmap)
            Toast.makeText(activity,""+tenfile,Toast.LENGTH_SHORT).show()

        }
    }


    private fun persistImage(bitmap: Bitmap): File? {
        val filesDir: File = (activity as HomeNavActivity).filesDir
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