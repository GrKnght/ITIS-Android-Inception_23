package com.kpfu.itis.android_inception_23.model

import androidx.annotation.DrawableRes

data class NewsDataModel(
    val newsId: String,
    val newsTitle: String,
    val newsDetails: String? = null,
    @DrawableRes val newsImage: Int? = null,
    val isLiked: Boolean = false,
)
