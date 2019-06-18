package com.example.bookhotels.uiview.selective

import android.content.Context
import android.util.Log
import com.example.bookhotels.dto.Hotels

class SelectivePresenter(val context: Context,val seletiveView: SeletiveView) {

    companion object {
        lateinit var danhsach:ArrayList<Hotels>
    }
    val selectiveModel=SelectiveModel(context)

    fun danhsachyeuthichd(){
        danhsach=ArrayList()
       danhsach= selectiveModel.laydanhsachyeuthich()
        if (danhsach.size>0){
            seletiveView.laydanhsachthanhcong(danhsach)
            Log.d("OOPOPOP",""+danhsach.size)
        }
        else {
            seletiveView.laydanhsachthatbai()
        }
    }
}