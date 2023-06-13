package com.example.zzingzzing.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zzingzzing.Entity.MessageInfo
import com.example.zzingzzing.Entity.TelInfo
import com.example.zzingzzing.R

class MessageListAdapter :
    ListAdapter<MessageInfo, MessageListAdapter.MessageViewHolder>(MessageComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.contents, current.upttime)
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageContents: TextView = itemView.findViewById(R.id.tvContents)
        private val messageUptTime: TextView = itemView.findViewById(R.id.tvUptTime)

        fun bind(upttime: String, contents: String) {
            messageContents.text = contents
            messageUptTime.text = upttime
        }

        companion object {
            fun create(parent: ViewGroup): MessageViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.message_list_item, parent, false)
                return MessageViewHolder(view)
            }
        }
    }

    class MessageComparator : DiffUtil.ItemCallback<MessageInfo>() {
        override fun areItemsTheSame(oldItem: MessageInfo, newItem: MessageInfo): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MessageInfo, newItem: MessageInfo): Boolean {
            return (oldItem.contents == newItem.contents &&
                    oldItem.upttime == newItem.upttime)
        }
    }
}