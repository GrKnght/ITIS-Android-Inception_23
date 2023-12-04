package com.kpfu.itis.android_inception_23.utils

import androidx.activity.result.contract.ActivityResultContracts
import com.kpfu.itis.android_inception_23.base.BaseActivity

class PermissionRequestHandler(
    activity: BaseActivity,
    private val callback: ((String?) -> Unit)? = null,
    private val rationaleCallback: (() -> Unit)? = null,
    private val deniedCallback: (() -> Unit)? = null,
) {

    private var currentPermission = ""

    private val singlePermissionLauncher =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                callback?.invoke(currentPermission)
            } else {
                if (currentPermission.isNotEmpty() && activity.shouldShowRequestPermissionRationale(currentPermission)) {
                    rationaleCallback?.invoke()
                } else {
                    deniedCallback?.invoke()
                }
            }
        }

    private val multiplePermissionsLauncher = activity.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        var check = true
        permissionsMap.forEach {
            if (!it.value) {
                check = false
                return@forEach
            }
        }
        if (check) {
            callback?.invoke(currentPermission)
        } else {
            permissionsMap.forEach {
                if (activity.shouldShowRequestPermissionRationale(it.key)) {
                    rationaleCallback?.invoke()
                } else {
                    deniedCallback?.invoke()
                }
            }
        }
    }

    fun requestPermission(permission: String) {
        this.currentPermission = permission
        singlePermissionLauncher.launch(permission)
    }
}