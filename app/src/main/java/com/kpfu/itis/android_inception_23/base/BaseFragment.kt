package com.kpfu.itis.android_inception_23.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showMessageInConsole("OnCreateCalled")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        showMessageInConsole("OnCreateViewCalled")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        showMessageInConsole("OnStartCalled")
    }

    override fun onResume() {
        super.onResume()
        showMessageInConsole("OnResumeCalled")
    }

    override fun onPause() {
        super.onPause()
        showMessageInConsole("OnPauseCalled")
    }

    override fun onStop() {
        super.onStop()
        showMessageInConsole("OnStopCalled")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showMessageInConsole("OnDestroyViewCalled")
    }

    override fun onDestroy() {
        super.onDestroy()
        showMessageInConsole("OnDestroyCalled")
    }

    private fun showMessageInConsole(message: String) {
        println("TEST TAG - $message ${this.javaClass.canonicalName}")
    }
}