package com.picpay.desafio.android.userlist.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.userlist.R
import com.picpay.desafio.android.utils.UserListDiffCallback
import com.picpay.desafio.android.userlist.ui.viewholder.UserListItemViewHolder
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse

class UserListAdapter : RecyclerView.Adapter<UserListItemViewHolder>() {

    var userList = mutableListOf<UserListResponse>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                UserListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}