package com.kpfu.itis.android_inception_23.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.databinding.ItemMyMessageBinding
import com.kpfu.itis.android_inception_23.model.MessageModel

class MyMessageHolder(
    private val viewBinding: ItemMyMessageBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindMyMessageItem(item: MessageModel) {
        viewBinding.myMessageTv.text = item.messageText
    }
}