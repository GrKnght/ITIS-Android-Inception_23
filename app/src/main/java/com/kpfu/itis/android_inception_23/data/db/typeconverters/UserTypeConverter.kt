package com.kpfu.itis.android_inception_23.data.db.typeconverters

import androidx.room.TypeConverter
import com.kpfu.itis.android_inception_23.model.UserModel

class UserTypeConverter {

    @TypeConverter
    fun fromUserToDbEntity(userData: UserModel): String {
        val resultStr = StringBuilder().apply {
            if (userData.emailAddress?.isNotEmpty() == true) {
                this.append(userData.emailAddress.toString())
                this.append(';')
            }
            this.append(userData.id)
            this.append(';')
            this.append(userData.name)
            this.append(';')
            this.append(userData.secondName)
        }
        return resultStr.toString()
    }

    @TypeConverter
    fun fromDbEntityToUserModel(input: String): UserModel {
        var index: Int = input.indexOf(';')
        val email: String? = if (input.contains('@')) {
            input.substringBefore(';')
        } else {
            null
        }
        return UserModel(
            id = "1",
            name = "2",
            secondName = "3",
            patronymic = "",
            emailAddress = email,
        )
    }
}