package com.kpfu.itis.android_inception_23.ui.holder

import android.os.Build
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.databinding.ItemQuestionBinding
import com.kpfu.itis.android_inception_23.model.QuestionData

class QuestionHolder(
    private val viewBinding: ItemQuestionBinding,
    private val onItemChecked: ((Int, Boolean) -> Unit)? = null,
    private val onRootClicked: ((Int) -> Unit)? = null,
) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            viewBinding.root.foreground = ""
//        } else {
//            viewBinding.root.background =
//        }

        viewBinding.questionCb.setOnCheckedChangeListener { _, isChecked ->
            onItemChecked?.invoke(adapterPosition, isChecked)
        }
        viewBinding.root.setOnClickListener {
            println("TEST TAG - Clicked")
            onRootClicked?.invoke(adapterPosition)
        }
    }

    fun bindItem(item: QuestionData, itemsCount: Int) {
        with(viewBinding) {
            questionTv.text = item.question

            questionCb.isChecked = item.isChecked
            divider.isVisible = adapterPosition != itemsCount - 1
        }
    }

    fun bindItemExtended(item: QuestionData) {

    }
}