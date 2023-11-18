package com.kpfu.itis.android_inception_23.ui.screen

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kpfu.itis.android_inception_23.ui.fragments.MainPageFragment
import com.kpfu.itis.android_inception_23.ui.fragments.NewsFeedFragment

object AppScreens {

    fun getMainPageScreen(arg2: String, arg3: String) = FragmentScreen("main_fragment") {
        MainPageFragment.newInstance(arg2, arg3)
    }

    fun getNewsFeedScreen() = FragmentScreen("news_feed_key") {
        NewsFeedFragment()
    }
}