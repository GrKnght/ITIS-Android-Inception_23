package com.kpfu.itis.android_inception_23

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.base.BaseActivity
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.databinding.ActivityMainBinding
import com.kpfu.itis.android_inception_23.model.NewsDataModel
import com.kpfu.itis.android_inception_23.utils.ActionType
import com.kpfu.itis.android_inception_23.utils.PermissionRequestHandler
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainActivity : BaseActivity() {

    override val fragmentContainerId: Int = R.id.main_activity_container

    private var permissionRequestHandler: PermissionRequestHandler? = null

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(viewBinding) {
            requestBtn.setOnClickListener {
                lifecycleScope.launch {
                    viewBinding.mainProgressBar.isVisible = true
                    runCatching {
                        // Работаем в главном потоке, т.к. не модифицировали контекст lifecycleScope
                        getNewsData(number = 1)
                    }.onSuccess { data ->
                        headerTv.text = data.newsTitle
                        mainProgressBar.isVisible = false
                    }.onFailure {
                        Toast.makeText(this@MainActivity, "Exception Occurred $it", Toast.LENGTH_SHORT).show()
                        mainProgressBar.isVisible = false
                    }
                }
            }

            asyncRequestBtn.setOnClickListener {
                lifecycleScope.launch {
                    mainProgressBar.isVisible = true
                    runCatching {
                        val jobsList = mutableListOf<Deferred<NewsDataModel>>()
                        withContext(Dispatchers.IO) {
                            var counter = 0
                            repeat(times = 5) {
                                jobsList.add(async(start = CoroutineStart.LAZY) { getNewsData(++counter) })
                            }
                            jobsList.awaitAll()
                        }
                    }.onSuccess { newsList ->
                        mainProgressBar.isVisible = false
                        // Do something
                    }.onFailure {
                        mainProgressBar.isVisible = false
                        // Handle error
                    }
                }
            }

            thirdRequestBtn.setOnClickListener {
                lifecycleScope.launch {
                    mainProgressBar.isVisible = true
                    runCatching {
                        withContext(Dispatchers.IO) {
                            getNewsData(1)
                        }
                    }.onSuccess { newsData ->
                        mainProgressBar.isVisible = false
                        // Do something
                    }.onFailure {
                        mainProgressBar.isVisible = false
                        // Handle error
                    }
                }
            }
        }
    }

    private suspend fun printData(number: Int) {
        delay(timeMillis = getRandom())
        println("TEST TAG - My job here is done ${number}")
    }

    private fun getRandom(): Long {
        val rand = Random.nextInt(1, 5)
        return rand * 1000L
    }

    private suspend fun getNewsData(number: Int): NewsDataModel {
        delay(getRandom())
        return NewsDataModel(newsId = "IdSamp", newsTitle = "TitleSamp")
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

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 12101
    }
}