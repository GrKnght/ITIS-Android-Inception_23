package com.kpfu.itis.android_inception_23.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.databinding.ItemOtherMessageBinding
import com.kpfu.itis.android_inception_23.model.MessageModel

class OtherMessageHolder(
    private val viewBinding: ItemOtherMessageBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindOtherMessageType(message: MessageModel) {
        viewBinding.otherMessageTv.text = message.messageText
    }
}