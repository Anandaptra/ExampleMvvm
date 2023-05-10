package com.example.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplemvvm.R
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        val viewModelUser = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModelUser.callApiNews()
        viewModelUser.liveDataNews.observe(this, Observer {
            if (it != null) {
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)
            }
        })
    }
}