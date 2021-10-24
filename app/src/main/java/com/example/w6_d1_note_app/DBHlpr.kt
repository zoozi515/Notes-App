package com.example.w6_d1_note_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr (context: Context?) : SQLiteOpenHelper(context, "noteApp.db", null, 1) {

    var sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            //Create the Database
            db.execSQL("create table notes (Message text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun savedata(s1 : String): Long{
        //Adding data to content holder
        val cv = ContentValues()
        cv.put("Message",s1)
        var status = sqLiteDatabase.insert("notes",null, cv)
        return status
    }
}