package com.picpay.desafio.android.contacts.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.contacts.R
import com.picpay.desafio.android.utils.UserListDiffCallback
import com.picpay.desafio.android.contacts.ui.viewholder.UserListItemViewHolder
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse

class UserListAdapter(val contacts: List<ContactsResponse>) : RecyclerView.Adapter<UserListItemViewHolder>() {

    var users = emptyList<ContactsResponse>()
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

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return UserListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size
}