package com.kpfu.itis.android_inception_23.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.kpfu.itis.android_inception_23.R

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    open fun getToolbar(): Toolbar? = view?.findViewById(R.id.toolbar)

    protected fun setToolbarTitle(@StringRes titleRes: Int) {
        getToolbar()?.setTitle(titleRes)
    }

    protected fun setToolbarTitle(title: String) {
        getToolbar()?.title = title
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(getToolbar() != null)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}