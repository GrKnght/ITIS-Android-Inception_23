package com.kpfu.itis.android_inception_23.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.databinding.ItemQuestionBinding
import com.kpfu.itis.android_inception_23.model.MessageModel
import com.kpfu.itis.android_inception_23.model.QuestionData
import com.kpfu.itis.android_inception_23.ui.holder.QuestionHolder

class QuestionnaireAdapter(
    val items: MutableList<QuestionData>,
    private val onItemChecked: ((Int, Boolean) -> Unit)? = null,
    private val onRootClicked: ((Int) -> Unit)? = null,
) : RecyclerView.Adapter<QuestionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        return QuestionHolder(
            viewBinding = ItemQuestionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemChecked = onItemChecked,
            onRootClicked = onRootClicked,
        )
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bindItem(item = items[position], itemCount)
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty() && (payloads.first() is MessageModel)) {
            holder.bindItemExtended(item = items[position])
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int = items.count()
}