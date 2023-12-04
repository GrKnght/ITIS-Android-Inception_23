package com.kpfu.itis.android_inception_23.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.kpfu.itis.android_inception_23.data.db.InceptionDatabase
import com.kpfu.itis.android_inception_23.data.db.migrations.MIGRATION_1_2

object ServiceLocator {

    private var dbInstance: InceptionDatabase? = null

    private var inceptionPref: SharedPreferences? = null

    fun initData(ctx: Context) {
        dbInstance = Room.databaseBuilder(ctx, InceptionDatabase::class.java, "inception.db")
            .addMigrations(
                MIGRATION_1_2()
            )
            .build()

        inceptionPref = ctx.getSharedPreferences("inception_pref", Context.MODE_PRIVATE)
    }

    fun getDbInstance(): InceptionDatabase {
        return dbInstance ?: throw IllegalStateException("Db not initialized")
    }

    fun getSharedPreferences(): SharedPreferences {
        return inceptionPref ?: throw IllegalStateException("Preferences not initialized")
    }
}