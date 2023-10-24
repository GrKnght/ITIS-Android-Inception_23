package com.kpfu.itis.android_inception_23

import android.os.Bundle
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.ui.fragments.NewsFeedFragment
import com.kpfu.itis.android_inception_23.utils.ActionType

class MainActivity : BaseActivity() {

    override val fragmentContainerId: Int = R.id.main_activity_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    fragmentContainerId,
                    NewsFeedFragment(),
                    NewsFeedFragment.NEWSFEED_FRAGMENT_TAG,
                )
                .commit()
        }
    }

    override fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        tag: String?,
        isAddToBackStack: Boolean,
    ) {
        supportFragmentManager.beginTransaction().apply {
            when (actionType) {
                ActionType.ADD -> {
                    this.add(fragmentContainerId, destination, tag)
                }

                ActionType.REPLACE -> {
                    this.replace(fragmentContainerId, destination, tag)
                }

                ActionType.REMOVE -> {
                    this.remove(destination)
                }

                else -> Unit
            }
            if (isAddToBackStack) {
                this.addToBackStack(null)
            }
        }.commit()
    }
}