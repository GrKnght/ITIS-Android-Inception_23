package com.kpfu.itis.android_inception_23.ui.fragments.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentNavigationMainBinding

class NavigationMainFragment : BaseFragment(R.layout.fragment_navigation_main) {

    private val viewBinding by viewBinding(FragmentNavigationMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val directions = NavigationSettingsFragmentDirections.actionGlobalSettingsFragment(
            settingsData = "Some string to pass"
        )

        viewBinding.actionBtn.setOnClickListener {
            findNavController().navigate(directions)
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int>("SAMPLE_KEY")
            ?.observe(viewLifecycleOwner) { intValue ->
                intValue?.let {
                    println("TEST TAG - Int Value received: $it")
                }
            }
    }
}