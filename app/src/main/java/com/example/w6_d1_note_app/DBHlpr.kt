package com.example.w6_d1_note_app

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr (context: Context?) : SQLiteOpenHelper(context, "noteApp.db", null, 1) {

    var sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            //Create the Database
            db.execSQL("create table notes (MyId INTEGER PRIMARY KEY, Message text)")
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

    @SuppressLint("Range")
    fun retrieveNote() : ArrayList<NoteModel> {
        val noteList: ArrayList<NoteModel> = ArrayList()
        val selectQuery = "SELECT * FROM notes"

        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var noteText: String

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("MyId"))
                noteText = cursor.getString(cursor.getColumnIndex("Message"))

                val note = NoteModel(id = id, noteText = noteText)
                noteList.add(note)
            } while (cursor.moveToNext())
        }

        return noteList
    }
}