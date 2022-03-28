package com.example.sharedpreferences_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        isRemembered= sharedPreferences.getBoolean("CHECKBOX",false)

        if(isRemembered){
            val intent = Intent(this,showDetails::class.java)
            startActivity(intent)
            finish()
        }

        val buttonDone = findViewById<Button>(R.id.done)




    }
}