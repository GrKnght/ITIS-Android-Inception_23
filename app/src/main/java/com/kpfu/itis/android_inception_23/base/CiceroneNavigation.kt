package com.kpfu.itis.android_inception_23.base

import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.Screen

interface CiceroneNavigation {

    fun navigateTo(destination: Screen, isNewRoot: Boolean = false)

    fun backTo(destination: Screen? = null)

    fun setResultListener(key: String, listener: ResultListener)

    fun removeResultListener(key: String)

    fun setResult(key: String, data: Any)
}