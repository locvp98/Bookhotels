//package com.example.bookhotels.uiview.selective
//
//import android.content.Context
//import android.util.Log
//import com.example.bookhotels.dto.Hotels
//
//class SelectivePresenter(val context: Context,val seletiveView: SeletiveView):Selectivelistener {
//
//    companion object {
//        lateinit var danhsach:ArrayList<Hotels>
//    }
//    val selectiveModel=SelectiveModel(context,this)
//
//    fun danhsachyeuthichd(){
//        selectiveModel.laydanhsachyeuthich()
//        Log.d("OOPOPOP",""+ "kkokokoko" )
//    }
//    override fun danhsachteuthich(danhsachlist: ArrayList<Hotels>) {
//        danhsach=ArrayList()
//        danhsach = danhsachlist
//        if (danhsach.size>0){
//            seletiveView!!.laydanhsachthanhcong(danhsach)
//            Log.d("OOPOPOP",""+danhsach.size)
//        }else{
//            Log.d("OOPOPOP",""+danhsach.size)
//            seletiveView.laydanhsachthatbai()
//        }
//    }
//}