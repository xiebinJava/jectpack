package com.fs.module.category.login.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fs.module.category.R

class UserInfoAdapter(private val list: List<String>, private val context:Context) : Adapter<UserInfoAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mvi_view,parent,false))
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textView.text = list[position]
    }

    class UserViewHolder(itemView: View) : ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.tv_item)
    }
}