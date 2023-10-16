package com.kpfu.itis.android_inception_23.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.adapter.CatalogAdapter
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentCatalogBinding
import com.kpfu.itis.android_inception_23.model.CatalogData

class CatalogFragment : BaseFragment(R.layout.fragment_catalog) {

    private val viewBinding: FragmentCatalogBinding by viewBinding(FragmentCatalogBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf(
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)),
            CatalogData("1", ContextCompat.getColor(requireContext(), R.color.purple_200)),
            CatalogData("3", ContextCompat.getColor(requireContext(), R.color.teal_200)),
            CatalogData("5", ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright))
        )
        val adapter = CatalogAdapter(action = {
            when (it.title) {
                "1" -> {
                    it.bgColor = ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)
                }

                "3" -> {
                    it.bgColor = ContextCompat.getColor(requireContext(), R.color.purple_200)
                }

                else -> {
                    it.bgColor = ContextCompat.getColor(requireContext(), R.color.teal_200)
                }
            }
        })
        viewBinding.catalogRv.adapter = adapter
        viewBinding.catalogRv.layoutManager = LinearLayoutManager(requireContext(),  RecyclerView.VERTICAL, false)
        adapter.items = data

    }
}