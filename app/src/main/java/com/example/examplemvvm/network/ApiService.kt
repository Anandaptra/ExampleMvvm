package com.example.examplemvvm.network

import com.example.examplemvvm.model.getAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun getAllUser() : Call<List<getAllUserItem>>

}