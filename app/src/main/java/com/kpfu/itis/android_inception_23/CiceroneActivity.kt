package com.kpfu.itis.android_inception_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kpfu.itis.android_inception_23.base.CiceroneNavigation
import com.kpfu.itis.android_inception_23.ui.screen.AppScreens

class CiceroneActivity : AppCompatActivity(), CiceroneNavigation {

    private val cicerone = Cicerone.create()

    private val router get() = cicerone.router

    private val navigatorHolder = cicerone.getNavigatorHolder()

    // AppNavigator - стандартная реализация Navigator-а. Так же можно написать свой Navigator
    //                если нужно какое-то кастомное поведение
    private val navigator = AppNavigator(activity = this, containerId = R.id.cicerone_container)

    private val listenersMap = mutableMapOf<String, ResultListenerHandler>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicerone)
        navigateTo(AppScreens.getNewsFeedScreen(), isNewRoot = true)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun navigateTo(destination: Screen, isNewRoot: Boolean) {
        if (isNewRoot) {
            router.newRootScreen(destination)
        } else {
            router.navigateTo(destination)
        }
    }

    override fun backTo(destination: Screen?) {
        router.backTo(destination)
    }

    override fun setResultListener(key: String, listener: ResultListener) {
        val handler = router.setResultListener(key, listener)
        listenersMap[key] = handler
    }

    override fun removeResultListener(key: String) {
        listenersMap[key]?.dispose()
        listenersMap.remove(key)
    }

    override fun setResult(key: String, data: Any) {
        router.sendResult(key, data)
    }
}