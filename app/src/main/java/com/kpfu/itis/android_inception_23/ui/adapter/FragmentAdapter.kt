package com.kpfu.itis.android_inception_23.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kpfu.itis.android_inception_23.ui.fragments.QuestionnaireFragment

class FragmentAdapter(manager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int = 15

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun createFragment(position: Int): Fragment {
        return QuestionnaireFragment()
    }
}