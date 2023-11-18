package com.kpfu.itis.android_inception_23

// import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.ActivityMainBinding
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

         // Переход к Activity с реализацией Cicerone
//        val intent = Intent(this, CiceroneActivity::class.java)
//        startActivity(intent)
        /**
         *  Стандартная реализация логики BottomNavigationView,
         *  если вы не используете Jetpack Navigation.
         */
//        findViewById<BottomNavigationView>(R.id.main_bottom_navigation)?.let { bottomNav ->
//            bottomNav.setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.mf_edit_item -> {
//                        Действие по нажатию на первую вкладку
//                        true
//                    }
//
//                    R.id.mf_edit_item2 -> {
//                        Действие по нажатию на вторую вкладку
//                        true
//                    }
//
//                    else -> {
//                        false
//                    }
//                }
//            }
        /**
         *  ReselectedListener - когда нужно обработать повторное нажатие
         *  на уже выбранный элемент меню
         */
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