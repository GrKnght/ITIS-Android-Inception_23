package com.kpfu.itis.android_inception_23

import android.app.Application
import com.kpfu.itis.android_inception_23.di.ServiceLocator

class InceptionApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.initData(ctx = this)
    }
}