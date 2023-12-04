package com.kpfu.itis.android_inception_23.ui.adapter

import android.os.Bundle
import android.view.View
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment

class NewsDetailsFragment : BaseFragment(R.layout.fragment_news_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val NEWS_DETAILS_FRAGMENT_TAG = "NEWS_DETAILS_FRAGMENT_TAG"
    }
}