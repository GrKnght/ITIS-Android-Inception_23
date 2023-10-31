package com.kpfu.itis.android_inception_23

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.ActivityMainBinding
import com.kpfu.itis.android_inception_23.ui.fragments.NewsFeedFragment
import com.kpfu.itis.android_inception_23.utils.ActionType

class MainActivity : BaseActivity(R.layout.activity_main) {

    override val fragmentContainerId: Int = R.id.main_activity_container

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolbar)

        val navHost = supportFragmentManager.findFragmentById(fragmentContainerId) as NavHostFragment
        NavigationUI.setupWithNavController(viewBinding.mainBottomNavigation, navHost.navController)

        NavigationUI.setupActionBarWithNavController(this, navHost.navController)

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .add(
//                    fragmentContainerId,
//                    NewsFeedFragment(),
//                    NewsFeedFragment.NEWSFEED_FRAGMENT_TAG,
//                )
//                .commit()
//        }
//        findViewById<BottomNavigationView>(R.id.main_bottom_navigation)?.let { bottomNav ->
//            bottomNav.setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.mf_edit_item -> {
//                        //
//                        println("TEST TAG - MF1")
//                        true
//                    }
//
//                    R.id.mf_edit_item2 -> {
//                        //
//                        println("TEST TAG - MF2")
//                        true
//                    }
//
//                    else -> {
//                        false
//                    }
//                }
//            }
//            bottomNav.setOnItemReselectedListener {}
//        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
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