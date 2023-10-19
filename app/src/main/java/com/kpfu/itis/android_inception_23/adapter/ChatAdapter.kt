package com.kpfu.itis.android_inception_23.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.databinding.ItemDataMessageBinding
import com.kpfu.itis.android_inception_23.databinding.ItemMyMessageBinding
import com.kpfu.itis.android_inception_23.databinding.ItemOtherMessageBinding
import com.kpfu.itis.android_inception_23.model.MessageModel
import com.kpfu.itis.android_inception_23.ui.holder.DataMessageHolder
import com.kpfu.itis.android_inception_23.ui.holder.MyMessageHolder
import com.kpfu.itis.android_inception_23.ui.holder.OtherMessageHolder
import com.kpfu.itis.android_inception_23.utils.UserMessagesTypes

class ChatAdapter(
    val items: MutableList<MessageModel>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            UserMessagesTypes.MY_MESSAGE.number -> {
                MyMessageHolder(
                    viewBinding = ItemMyMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            UserMessagesTypes.OTHER_MESSAGE.number -> {
                OtherMessageHolder(
                    viewBinding = ItemOtherMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                DataMessageHolder(
                    viewBinding = ItemDataMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyMessageHolder -> {
                holder.bindMyMessageItem(item = items[position])
            }

            is OtherMessageHolder -> {
                holder.bindOtherMessageType(message = items[position])
            }

            is DataMessageHolder -> {
                holder.bindDataMessage(date = items[position].messageDate)
            }

            else -> Unit
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        val currentItem = items[position]
        return when {
            currentItem.isCurrentUserMessage -> UserMessagesTypes.MY_MESSAGE.number
            !currentItem.isCurrentUserMessage -> UserMessagesTypes.OTHER_MESSAGE.number
            else -> UserMessagesTypes.DATA_MESSAGE.number
        }
    }
}