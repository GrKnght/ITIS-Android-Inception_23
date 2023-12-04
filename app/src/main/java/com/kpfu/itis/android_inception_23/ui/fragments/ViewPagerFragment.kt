package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.ui.adapter.FragmentAdapter
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentViewPagerBinding

class ViewPagerFragment : BaseFragment(R.layout.fragment_view_pager) {

    private val viewBinding: FragmentViewPagerBinding by viewBinding(FragmentViewPagerBinding::bind)

    private var vpAdapter: FragmentAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vpAdapter = FragmentAdapter(manager = parentFragmentManager, lifecycle)
        viewBinding.fragmentVp.adapter = vpAdapter
    }
}