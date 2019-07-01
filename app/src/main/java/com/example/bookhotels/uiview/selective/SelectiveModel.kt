package com.example.bookhotels.uiview.selective

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.bookhotels.adapter.DiscoveryAdapter
import com.example.bookhotels.dto.Hotels

class SelectiveModel(val context: Context) {


    lateinit var database: SQLiteDatabase

    fun themyeuthich(hotel: Hotels): Boolean {
        val dataselective: DataSelective = DataSelective(context)
        val db: SQLiteDatabase = dataselective.getWritableDatabase()

        var contentValues: ContentValues = ContentValues()
        contentValues.put(DataSelective.TB_YEUTHICH_ID, hotel._idhotels)
        contentValues.put(DataSelective.TB_YEUTHICH_DIACHI, hotel.diachi)
        contentValues.put(DataSelective.TB_YEUTHICH_GIAPHONG, hotel.giaphong)
        contentValues.put(DataSelective.TB_YEUTHICH_MASO, hotel.maso)
        contentValues.put(DataSelective.TB_YEUTHICH_CHITIETPHONG, hotel.chitietphong)
        contentValues.put(DataSelective.TB_YEUTHICH_IMAGE, hotel.image)
        contentValues.put(DataSelective.TB_YEUTHICH_TENPHONG, hotel.tenphong)

        val kiemtra: Long = db.insert(DataSelective.TB_YEUTHICH, null, contentValues)
        return kiemtra > 0

    }

    fun laydanhsachyeuthich(): ArrayList<Hotels> {

        val dataselective: DataSelective = DataSelective(context)
        val db: SQLiteDatabase = dataselective.getWritableDatabase()
        var hotellist: ArrayList<Hotels> = ArrayList()

        val truyvan: String = "SELECT * FROM ${DataSelective.TB_YEUTHICH}"
        val cursor: Cursor = db.rawQuery(truyvan, null)

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                var hotel: Hotels = Hotels()

                hotel._idhotels = cursor.getString(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_ID))
                hotel.diachi = cursor.getString(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_DIACHI))
                hotel.maso = cursor.getInt(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_MASO))
                hotel.chitietphong = cursor.getString(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_CHITIETPHONG))
                hotel.image = cursor.getString(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_IMAGE))
                hotel.giaphong = cursor.getInt(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_GIAPHONG))
                hotel.tenphong = cursor.getString(cursor.getColumnIndex(DataSelective.TB_YEUTHICH_TENPHONG))

                hotellist.add(hotel)
                cursor.moveToNext()
            }
        }
        Log.d("AAAAAAA", "" + "kkokokoko" + hotellist.size)
        return hotellist

    }
}