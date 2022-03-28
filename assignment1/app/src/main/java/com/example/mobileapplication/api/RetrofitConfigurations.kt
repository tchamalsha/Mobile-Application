package com.example.mobileapplication.api

import com.example.myapplication.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService{
//    @GET("users")
//    fun getUsers(): Call<List<User>>

    @GET("users/{userID}")
    fun getUser(@Path("userID") id:String):Call<User>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com/"
        fun create():UserAPIService {

            val retrofit  = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(UserAPIService::class.java)

        }


    }
}
class RetrofitConfigurations {



}