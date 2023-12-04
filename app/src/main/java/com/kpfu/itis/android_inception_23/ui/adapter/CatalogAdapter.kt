package com.kpfu.itis.android_inception_23.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.databinding.ItemCatalogBinding
import com.kpfu.itis.android_inception_23.model.CatalogData

class CatalogAdapter(
    val action: (CatalogData) -> Unit
) : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    var items: MutableList<CatalogData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            viewBinding = ItemCatalogBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CatalogViewHolder(private val viewBinding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.rvActionBtn.setOnClickListener {
                action(items[adapterPosition])
                viewBinding.rvActionBtn.isEnabled = false
                notifyItemChanged(adapterPosition)
            }
        }

        fun bindItem(data: CatalogData) {
            viewBinding.titleTv.text = data.title
            viewBinding.root.setBackgroundColor(items[adapterPosition].bgColor)
        }
    }
}