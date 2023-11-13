package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentNofiticationCenterBinding
import com.kpfu.itis.android_inception_23.utils.NotificationsHandler

class NotificationsCenterFragment : BaseFragment(R.layout.fragment_nofitication_center) {

    private val viewBinding by viewBinding(FragmentNofiticationCenterBinding::bind)

    private val notificationHandler = NotificationsHandler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.showNotificationBtn.setOnClickListener {
            notificationHandler.createNotification(ctx = requireContext(), 122)
        }
    }
}