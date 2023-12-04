package com.kpfu.itis.android_inception_23.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kpfu.itis.android_inception_23.data.db.dao.UserDao
import com.kpfu.itis.android_inception_23.data.db.entity.FilmEntity
import com.kpfu.itis.android_inception_23.data.db.entity.UserEntity
import com.kpfu.itis.android_inception_23.data.db.typeconverters.UserGsonTypeConverter
import com.kpfu.itis.android_inception_23.data.db.typeconverters.UserTypeConverter

@Database(
    entities = [UserEntity::class, FilmEntity::class],
    version = 2
)
// @TypeConverters(UserTypeConverter::class)
@TypeConverters(UserGsonTypeConverter::class)
abstract class InceptionDatabase : RoomDatabase() {

    abstract val userDao: UserDao
}