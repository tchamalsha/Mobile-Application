package com.example.mobileapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.mobileapplication.api.UserAPIService
import com.example.mobileapplication.databinding.FragmentFirstBinding
import com.example.myapplication.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val userAPIService = UserAPIService.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun getSet(view : View){

        val editText = findViewById<EditText>(R.id.textID);
        val message = editText.text.toString();

        val user = userAPIService.getUser(message);

        user.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val body = response.body()
                body?.let {
                     findViewById<TextView>(R.id.nameText).apply { text=it.name }
                     findViewById<TextView>(R.id.emailText).apply { text=it.email }
                     findViewById<TextView>(R.id.usernameText).apply { text=it.username }
                     findViewById<TextView>(R.id.phoneText).apply { text=it.phone }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }


        })

    }
}

