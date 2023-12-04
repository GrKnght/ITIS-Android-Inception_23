package com.kpfu.itis.android_inception_23.data.db.entity.tuple

import androidx.room.ColumnInfo

class UserAddressTuple(
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "email")
    val emailAddress: String,
)