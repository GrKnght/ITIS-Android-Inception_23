package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentTextInputBinding

class TextInputFragment : BaseFragment(R.layout.fragment_text_input) {

    private val viewBinding: FragmentTextInputBinding by viewBinding(FragmentTextInputBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(R.string.text_input_screen_title)
        initTextChangedListeners()
    }

    private fun initTextChangedListeners() {
        with(viewBinding) {
            phoneEt.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(input: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {
                    input?.let {
                        if (input.length > 3 && start > 0 && before == 0) {
                            phoneEt.removeTextChangedListener(this)
                            phoneEt.setText("${input}TT")
                            phoneEt.setSelection(phoneEt.text?.length ?: 0)
                            phoneEt.addTextChangedListener(this)
                        }
                    }
                }

                override fun afterTextChanged(input: Editable?) {}
            })
        }
    }

    companion object {
        const val TEXT_INPUT_FRAGMENT_TAG = "TEXT_INPUT_FRAGMENT_TAG"
    }
}