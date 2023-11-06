package com.kpfu.itis.android_inception_23.ui.screen

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kpfu.itis.android_inception_23.ui.fragments.MainPageFragment

object AppScreens {

    fun MainPageFragmentScreen(arg2: String, arg3: String) = FragmentScreen("main_fragment") {
        MainPageFragment.newInstance(arg2, arg3)
    }
}