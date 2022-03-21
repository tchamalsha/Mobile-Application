package com.example.mobileapplication.api

import com.example.myapplication.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService{
//    @GET("users")
//    fun getUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("userID") id:String):Call<User>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com/"
        val retrofit  = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userServices = retrofit.create(UserService::class.java)

    }
}
class RetrofitConfigurations {



}