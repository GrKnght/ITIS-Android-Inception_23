package com.kpfu.itis.android_inception_23.model

data class MessageModel(
    val messageText: String,
    val id: String,
    val isCurrentUserMessage: Boolean,
    val messageDate: String,
)
