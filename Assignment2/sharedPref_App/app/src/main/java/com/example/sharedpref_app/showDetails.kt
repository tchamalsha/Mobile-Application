package com.example.sharedpref_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class showDetails : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val email = preferences.getString("EMAIL","")
        val username = preferences.getString("USERNAME","")
        val ckecked = preferences.getBoolean("CHECKBOX",false)

        findViewById<TextView>(R.id.emailBox).apply { text=email }
        findViewById<TextView>(R.id.userNameBox).apply { text=username }
        findViewById<TextView>(R.id.checkBoxValue).apply { text=ckecked.toString() }

        val logoutButton = findViewById<Button>(R.id.logOut)

        logoutButton.setOnClickListener{
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.apply()
            editor.clear()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}