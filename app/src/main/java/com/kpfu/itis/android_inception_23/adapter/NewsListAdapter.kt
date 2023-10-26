package com.kpfu.itis.android_inception_23.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kpfu.itis.android_inception_23.databinding.ItemNewsfeedCvBinding
import com.kpfu.itis.android_inception_23.model.NewsDataModel
import com.kpfu.itis.android_inception_23.ui.holder.NewsfeedViewHolder

class NewsListAdapter(
    diffCallback: DiffUtil.ItemCallback<NewsDataModel>,
    private val onNewsClicked: ((NewsDataModel) -> Unit),
    private val onLikeClicked: ((Int, NewsDataModel) -> Unit),
) : ListAdapter<NewsDataModel, NewsfeedViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsfeedViewHolder {
        return NewsfeedViewHolder(
            viewBinding = ItemNewsfeedCvBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onNewsClicked = onNewsClicked,
            onLikeClicked = onLikeClicked,
        )
    }

    override fun onBindViewHolder(holder: NewsfeedViewHolder, position: Int) {
        (holder as? NewsfeedViewHolder)?.bindItem(item = getItem(position))
    }
}

