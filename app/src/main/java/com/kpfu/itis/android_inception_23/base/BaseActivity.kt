package com.kpfu.itis.android_inception_23.base

import androidx.appcompat.app.AppCompatActivity
import com.kpfu.itis.android_inception_23.utils.ActionType

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val fragmentContainerId: Int

    abstract fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        tag: String? = null,
        isAddToBackStack: Boolean = true,
    )
}