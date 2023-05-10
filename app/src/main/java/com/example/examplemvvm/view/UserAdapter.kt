package com.example.examplemvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplemvvm.databinding.ItemUserBinding
import com.example.examplemvvm.model.getAllUserItem

class UserAdapter (var listUser : List<getAllUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.binding.tvNama.text= listUser[position].name
        holder.binding.tvUmur.text = listUser[position].age.toString()
        holder.binding.tvAlamat.text = listUser[position].address
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

}