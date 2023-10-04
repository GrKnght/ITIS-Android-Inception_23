package com.kpfu.itis.android_inception_23.ui.fragments

import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentTextInputBinding

class TextInputFragment : BaseFragment(R.layout.fragment_text_input) {

    private val viewBinding: FragmentTextInputBinding by viewBinding(FragmentTextInputBinding::bind)

    companion object {
        const val TEXT_INPUT_FRAGMENT_TAG = "TEXT_INPUT_FRAGMENT_TAG"
    }
}