package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.databinding.DialogSampleFragmentBinding
import com.kpfu.itis.android_inception_23.utils.ParamsKey

class SampleDialogFragment : BottomSheetDialogFragment(R.layout.dialog_sample_fragment) {

    private val viewBinding: DialogSampleFragmentBinding by viewBinding(DialogSampleFragmentBinding::bind)
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.dialog_sample_fragment, container, false)
//        (view.layoutParams as? ConstraintLayout.LayoutParams)?.apply {
//        }
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calculateViewDialogHeight()
        viewBinding.dialogFirstBtn.setOnClickListener {
            parentFragmentManager.setFragmentResult(ParamsKey.DIALOG_RESULT_KEY, bundleOf("first" to "second"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun calculateViewDialogHeight() {
        val displayMetrics = requireContext().resources.displayMetrics
        val dialogHeight = displayMetrics.heightPixels / 3

        val layoutParams =
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .apply {
                    height = dialogHeight
                }

        this.viewBinding.root.layoutParams = layoutParams
    }

    companion object {
        const val SAMPLE_DIALOG_FRAGMENT_TAG = "SAMPLE_DIALOG_FRAGMENT_TAG"

        fun newInstance() = SampleDialogFragment()
    }
}