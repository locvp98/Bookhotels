package com.example.bookhotels.uiview.selective

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.View

class DataSelective(context: Context?):SQLiteOpenHelper(context, "SQLYEUTHICH", null, 1) {

    companion object {
        val TB_YEUTHICH:String = "YEUTHICH"
        val TB_YEUTHICH_ID:String = "id"
        val TB_YEUTHICH_DIACHI:String = "DIACHI"
        val TB_YEUTHICH_IMAGE:String = "IMAGE"
        val TB_YEUTHICH_GIAPHONG:String = "GIAPHONG"
        val TB_YEUTHICH_MASO:String = "MASO"
        val TB_YEUTHICH_CHITIETPHONG:String = "CHITIETPHONG"
        val TB_YEUTHICH_TENPHONG:String = "TENPHONG"

    }



    override fun onCreate(db: SQLiteDatabase?) {
        val tbyeuthich = " CREATE TABLE " + TB_YEUTHICH + " ( " +
                TB_YEUTHICH_ID + " TEXT primary key, " +
                TB_YEUTHICH_DIACHI + " text, " +
                TB_YEUTHICH_GIAPHONG + " INTEGER, " +
                TB_YEUTHICH_MASO + " INTEGER, " +
                TB_YEUTHICH_CHITIETPHONG + " text, " +
                TB_YEUTHICH_IMAGE + " text, " +
                TB_YEUTHICH_TENPHONG + " text )"

        db!!.execSQL(tbyeuthich)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}