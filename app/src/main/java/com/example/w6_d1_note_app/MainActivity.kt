package com.example.w6_d1_note_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edmsg : EditText
    lateinit var btnsav : Button

    var s1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edmsg = findViewById(R.id.messageEditText)
        btnsav = findViewById(R.id.saveButton)
        btnsav.setOnClickListener {
            s1 = edmsg.text.toString()

            var dbhr = DBHlpr(applicationContext)
            var status = dbhr.savedata(s1)
            Toast.makeText(applicationContext,"Data Saves Successfully " + status, Toast.LENGTH_SHORT).show()
        }

    }
}