package com.kpfu.itis.android_inception_23.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.adapter.diffutil.NewsDiffUtil
import com.kpfu.itis.android_inception_23.databinding.ItemNewsfeedCvBinding
import com.kpfu.itis.android_inception_23.model.NewsDataModel
import com.kpfu.itis.android_inception_23.ui.holder.NewsfeedViewHolder

class NewsAdapter(
    private val onNewsClicked: ((NewsDataModel) -> Unit),
    private val onLikeClicked: ((Int, NewsDataModel) -> Unit),
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var newsList = mutableListOf<NewsDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsfeedViewHolder(
            viewBinding = ItemNewsfeedCvBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onNewsClicked = onNewsClicked,
            onLikeClicked = onLikeClicked,
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? NewsfeedViewHolder)?.bindItem(item = newsList[position])
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            (payloads.first() as? Boolean)?.let {
                (holder as? NewsfeedViewHolder)?.changeLikeBtnStatus(it)
            }
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int = newsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<NewsDataModel>) {
        val diff = NewsDiffUtil(oldItemsList = newsList, newItemsList = list)
        val diffResult = DiffUtil.calculateDiff(diff)
        newsList.clear()
        newsList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateItem(position: Int, item: NewsDataModel) {
        this.newsList[position] = item
        notifyItemChanged(position, item.isLiked)
    }
}