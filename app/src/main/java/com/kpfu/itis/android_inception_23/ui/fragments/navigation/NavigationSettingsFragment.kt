package com.kpfu.itis.android_inception_23.ui.fragments.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentNavigationSettingsBinding
import kotlin.random.Random

class NavigationSettingsFragment : BaseFragment(R.layout.fragment_navigation_settings) {

    private val viewBinding by viewBinding(FragmentNavigationSettingsBinding::bind)

    private val settingsArgDelegate: NavigationSettingsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(FIRST_ARG_TAG)?.let {
            println("TEST TAG - Received Value: $it")
        }


        viewBinding.actionBtn.setOnClickListener {
            val intValue = Random.nextInt(0, 100)
            findNavController().previousBackStackEntry?.savedStateHandle?.set("SAMPLE_KEY", intValue)
        }
    }

    companion object {
        const val FIRST_ARG_TAG = "FIRST_ARG"
    }
}