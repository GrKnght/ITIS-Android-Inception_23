package com.kpfu.itis.android_inception_23.ui

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.ui.fragments.NewsFeedFragment
import com.kpfu.itis.android_inception_23.ui.fragments.NotificationsCenterFragment
import com.kpfu.itis.android_inception_23.ui.fragments.auth.AuthFragment
import com.kpfu.itis.android_inception_23.utils.ActionType
import com.kpfu.itis.android_inception_23.utils.PermissionRequestHandler

class MainActivity : BaseActivity() {

    override val fragmentContainerId: Int = R.id.main_activity_container

    private var permissionRequestHandler: PermissionRequestHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    fragmentContainerId,
                    AuthFragment(),
                    AuthFragment.AUTH_FRAGMENT_TAG,
                )
                .commit()
        }
        permissionRequestHandler = PermissionRequestHandler(
            activity = this,
            callback = {
                Toast.makeText(this, "Permission granted: $it", Toast.LENGTH_LONG).show()
            }
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermission(android.Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    fun requestPermission(permission: String) {
        // ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        permissionRequestHandler?.requestPermission(permission)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted: ${permissions.first()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun goToScreen(
        actionType: ActionType,
        destination: BaseFragment,
        tag: String?,
        isAddToBackStack: Boolean,
    ) {
        supportFragmentManager.beginTransaction().apply {
            when (actionType) {
                ActionType.ADD -> {
                    this.add(fragmentContainerId, destination, tag)
                }

                ActionType.REPLACE -> {
                    this.replace(fragmentContainerId, destination, tag)
                }

                ActionType.REMOVE -> {
                    this.remove(destination)
                }

                else -> Unit
            }
            if (isAddToBackStack) {
                this.addToBackStack(null)
            }
        }.commit()
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 12101
    }
}