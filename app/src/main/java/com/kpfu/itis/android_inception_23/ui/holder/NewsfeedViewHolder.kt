package com.kpfu.itis.android_inception_23.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.databinding.ItemNewsfeedBinding
import com.kpfu.itis.android_inception_23.model.NewsDataModel

class NewsfeedViewHolder(
    private val viewBinding: ItemNewsfeedBinding,
    private val onNewsClicked: ((NewsDataModel) -> Unit),
    private val onLikeClicked: ((Int, NewsDataModel) -> Unit),
) : RecyclerView.ViewHolder(viewBinding.root) {

    private var item: NewsDataModel? = null

    init {
        viewBinding.root.setOnClickListener {
            this.item?.let(onNewsClicked)
        }
        viewBinding.likeBtnIv.setOnClickListener {
            this.item?.let {
                val data = it.copy(isLiked = !it.isLiked)
                onLikeClicked(adapterPosition, data)
            }
        }
    }

    fun bindItem(item: NewsDataModel) {
        this.item = item
        with(viewBinding) {
            newsTitleTv.text = item.newsTitle
            item.newsDetails?.let { newsDetailsTv.text = it }
            item.newsImage?.let { res ->
                newsImageIv.setImageResource(res)
            }
            val likeDrawable = if (item.isLiked) R.drawable.ic_like_red else R.drawable.ic_like_gray
            likeBtnIv.setImageResource(likeDrawable)
        }
    }
}