package com.kpfu.itis.android_inception_23.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kpfu.itis.android_inception_23.utils.ActionType

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val fragmentContainerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.registerFragmentLifecycleCallbacks(object :
            FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentViewCreated(
                fm: FragmentManager,
                fragment: Fragment,
                v: View,
                savedInstanceState: Bundle?
            ) {
                super.onFragmentViewCreated(fm, fragment, v, savedInstanceState)
                (fragment as? BaseFragment)?.getToolbar()?.let { safeToolbar ->
                    this@BaseActivity.setSupportActionBar(safeToolbar)
                    supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount > 0)
                }
            }
        }, false)
    }

    abstract fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        tag: String? = null,
        isAddToBackStack: Boolean = true,
    )
}