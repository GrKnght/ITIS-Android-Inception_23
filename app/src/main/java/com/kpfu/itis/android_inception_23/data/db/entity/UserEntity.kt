package com.kpfu.itis.android_inception_23.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo(name = "second_name")
    val secondName: String,
    val patronymic: String?,
    @ColumnInfo(name = "email")
    val emailAddress: String?,
    @ColumnInfo(name = "address")
    val address: String,
)
