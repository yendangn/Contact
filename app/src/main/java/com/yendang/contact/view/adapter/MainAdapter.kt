package com.yendang.contact.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yendang.contact.R

import com.yendang.contact.schema.Contact
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by yendang on 5/21/17.
 */

class MainAdapter(private val data: List<Contact>, private val context: Context, private val listener: MainAdapter.OnItemClickListener) : RecyclerView.Adapter<MainAdapter.ContactViewHolder>() {

    public interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ContactViewHolder? {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.contact_item_layout, viewGroup, false)
        val viewHolder = ContactViewHolder(view)

        return viewHolder

    }

    override fun onBindViewHolder(contactViewHolder: ContactViewHolder, i: Int) {

        val contactItem = data.getOrNull(i)

        if (contactItem != null) {
            contactViewHolder.tvName.text = contactItem.name
            contactViewHolder.tvPhone.text = contactItem.phoneNumber
            contactViewHolder.imgAvatar.setImageResource(contactItem.avatar)

            contactViewHolder.itemView.setOnClickListener({ listener.onItemClick(i) })
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView.findViewById(R.id.tvName) as TextView
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhoneNumber) as TextView
        val imgAvatar: CircleImageView = itemView.findViewById(R.id.imgProfileImage) as CircleImageView

    }
}
