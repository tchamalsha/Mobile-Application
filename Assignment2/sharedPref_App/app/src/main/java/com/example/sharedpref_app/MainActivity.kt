package com.example.sharedpref_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered= sharedPreferences.getBoolean("CHECKBOX",false)

        val buttonDone = findViewById<Button>(R.id.done)

        buttonDone.setOnClickListener{
            val emailVal = findViewById<EditText>(R.id.email).text.toString()
            val userNameVal = findViewById<EditText>(R.id.userName).text.toString()
            val checkBoxVal = findViewById<CheckBox>(R.id.checkbox).isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("EMAIL",emailVal)
            editor.putString("USERNAME",userNameVal)
            editor.putBoolean("CHECKBOX",checkBoxVal)
            editor.apply()


            Toast.makeText(this,"Information Saved!!",Toast.LENGTH_LONG).show()
            val intent = Intent(this,showDetails::class.java)
            startActivity(intent)
            finish()
        }



    }
}