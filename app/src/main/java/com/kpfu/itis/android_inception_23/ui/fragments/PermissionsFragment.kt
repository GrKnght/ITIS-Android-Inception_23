package com.kpfu.itis.android_inception_23.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.MainActivity
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.FragmentPermissionBinding
import com.kpfu.itis.android_inception_23.utils.ParamsKey

class PermissionsFragment : BaseFragment(R.layout.fragment_permission) {

    private val viewBinding by viewBinding(FragmentPermissionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            requestPermActionBtn.setOnClickListener {
                (requireActivity() as? MainActivity)?.requestPermission(permission = Manifest.permission.CAMERA)
            }
            checkPermActionBtn.setOnClickListener {
//                if (ContextCompat.checkSelfPermission(
//                        requireContext(),
//                        Manifest.permission.CAMERA,
//                    ) == PackageManager.PERMISSION_DENIED
//                ) {
//                    if (requireActivity().shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//
//                    } else {
//                        AlertDialog.Builder(requireContext())
//                            .setTitle("Sample")
//                            .setMessage("Message")
//                            .setPositiveButton(
//                                "Confirm"
//                            ) { dialog, which -> }
//                            .setNegativeButton("Reject", { dialog, which -> })
//                            .create()
//                    }
//                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_activity_container, NewsFeedFragment())
                    .addToBackStack(null)
                    .commit()

            }
        }
        parentFragmentManager.setFragmentResultListener(
            ParamsKey.DIALOG_RESULT_KEY,
            this.viewLifecycleOwner
        ) { requestKey, result ->
            result.getString("first")?.let {
                println("TEST TAG - Received $it")
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(requireActivity(), "Permission Granted: ${permissions.first()}", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (requireActivity().shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Toast.makeText(requireActivity(), "First", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        AlertDialog.Builder(requireContext())
                            .setTitle(getString(R.string.permission_denied_pattern, "Камера"))
                            .setMessage(getString(R.string.permission_denined_desc))
                            .setPositiveButton(
                                getString(R.string.go_to_settings)
                            ) { dialog, which ->

                            }
                            .show()
                    }
                }
            }
        }
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 12101
    }
}