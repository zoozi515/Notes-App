package com.example.w6_d1_note_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var dbhr : DBHlpr
    lateinit var edmsg : EditText
    lateinit var btnsav : Button
    lateinit var rvnote : RecyclerView

    var s1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbhr = DBHlpr(applicationContext)

        edmsg = findViewById(R.id.messageEditText)
        btnsav = findViewById(R.id.saveButton)
        btnsav.setOnClickListener {
           saveNote()
        }

        rvnote = findViewById(R.id.recyclerView)
        updateRV()
    }

    fun saveNote(){
        s1 = edmsg.text.toString()
        var status = dbhr.savedata(s1)
        Toast.makeText(applicationContext,"Data Saves Successfully " + status, Toast.LENGTH_SHORT).show()
    }

     fun updateRV(){
         rvnote.adapter = RVAdapter(this, getItemsList())
         rvnote.layoutManager = LinearLayoutManager(this)
    }

     fun getItemsList(): ArrayList<NoteModel>{
        return dbhr.retrieveNote()
    }

}