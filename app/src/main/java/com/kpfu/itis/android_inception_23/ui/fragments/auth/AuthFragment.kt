package com.kpfu.itis.android_inception_23.ui.fragments.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.base.BaseFragment
import com.kpfu.itis.android_inception_23.data.db.entity.UserEntity
import com.kpfu.itis.android_inception_23.databinding.FragmentAuthBinding
import com.kpfu.itis.android_inception_23.di.ServiceLocator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    private val viewBinding by viewBinding(FragmentAuthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counter = 0
        lifecycleScope.launch {
            val usersList = withContext(Dispatchers.IO) {
                ServiceLocator.getDbInstance().userDao.getAllUsers()
            }
        }
        viewBinding.actionBtn.setOnClickListener {
            val userEntity = UserEntity(
                id = "user_id_${++counter}",
                name = "FirstName",
                secondName = "SecondName",
                patronymic = "Third",
                emailAddress = "sampleEmail@mail.com",
                address = "Kazan"
            )
            lifecycleScope.launch(Dispatchers.IO) {
                ServiceLocator.getDbInstance().userDao.addUser(userEntity)
            }
        }

        ServiceLocator.getSharedPreferences()
            .edit()
            .putString("AuthToken", "tokenSmaple: 3sfasf")
            .apply()

        val userToken = ServiceLocator.getSharedPreferences()
            .getString("AuthToken", "")

        if (userToken?.isEmpty() == true) {

        }
    }

    companion object {
        const val AUTH_FRAGMENT_TAG = "AUTH_FRAGMENT"
    }
}