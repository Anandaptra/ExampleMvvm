package com.example.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.model.getAllUserItem
import com.example.examplemvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel(){
    var liveDataNews : MutableLiveData<List<getAllUserItem>?> = MutableLiveData()

    fun callApiNews(){
        ApiClient.instance.getAllUser().enqueue(object : Callback<List<getAllUserItem>> {
            override fun onResponse(
                call: Call<List<getAllUserItem>>,
                response: Response<List<getAllUserItem>>
            ) {
                if (response.isSuccessful) {
                    liveDataNews.postValue(response.body())
                } else {
                    liveDataNews.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                liveDataNews.postValue(null)
            }
        })
    }

}