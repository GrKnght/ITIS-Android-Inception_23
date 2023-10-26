package com.kpfu.itis.android_inception_23.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.kpfu.itis.android_inception_23.model.NewsDataModel

class NewsDiffUtilItemCallback : DiffUtil.ItemCallback<NewsDataModel>() {

    override fun areItemsTheSame(oldItem: NewsDataModel, newItem: NewsDataModel): Boolean {
        return oldItem.newsId == newItem.newsId
    }

    override fun areContentsTheSame(oldItem: NewsDataModel, newItem: NewsDataModel): Boolean {
        return oldItem.isLiked == newItem.isLiked
    }
}