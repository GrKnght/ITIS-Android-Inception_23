package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentMainPageBinding
import com.kpfu.itis.android_inception_23.ui.fragments.SampleDialogFragment.Companion.SAMPLE_DIALOG_FRAGMENT_TAG
import com.kpfu.itis.android_inception_23.utils.ActionType
import com.kpfu.itis.android_inception_23.utils.ParamsKey

class MainPageFragment : BaseFragment(R.layout.fragment_text_input) {

    private var _viewBinding: FragmentMainPageBinding? = null
    private val viewBinding: FragmentMainPageBinding
        get() = _viewBinding!!

    private val viewBindingDelegate by viewBinding(FragmentMainPageBinding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = FragmentMainPageBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mf_edit_item -> {
                Toast.makeText(requireContext(), "Menu item clicked", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        with(viewBinding) {
            arguments?.getString(ParamsKey.TITLE_TEXT_KEY)?.let { title ->
                headerTextTv.text = title
            }
            arguments?.getString(ParamsKey.MESSAGE_TEXT_KEY)?.let { message ->
                messageTextTv.text = message
            }
            mainPageActionBtn.setOnClickListener {
                (requireActivity() as? BaseActivity)?.goToScreen(
                    actionType = ActionType.REPLACE,
                    destination = CatalogFragment(),
                    tag = TextInputFragment.TEXT_INPUT_FRAGMENT_TAG,
                    isAddToBackStack = true,
                )
            }
        }
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }

    companion object {
        const val MAIN_PAGE_FRAGMENT_TAG = "MAIN_PAGE_FRAGMENT_TAG"

        fun getInstance(header: String, message: String): MainPageFragment {
            val bundle = Bundle().apply {
                putString(ParamsKey.TITLE_TEXT_KEY, header)
                putString(ParamsKey.MESSAGE_TEXT_KEY, message)
            }
            val fragment = MainPageFragment().apply {
                arguments = bundle
            }
            return fragment
        }

        fun newInstance(header: String, message: String) = MainPageFragment().apply {
            arguments = bundleOf(ParamsKey.TITLE_TEXT_KEY to header, ParamsKey.MESSAGE_TEXT_KEY to message)
        }
    }
}