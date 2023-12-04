package com.kpfu.itis.android_inception_23.ui.adapter.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SimpleHorizontalMarginDecorator(
    private val itemOffset: Int
) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        with(outRect) {
            left = itemOffset
            right = itemOffset
        }
    }
}