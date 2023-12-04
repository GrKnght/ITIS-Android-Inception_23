package com.kpfu.itis.android_inception_23.data.db.migrations

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MIGRATION_2_3 : Migration(2, 3) {

    override fun migrate(db: SupportSQLiteDatabase) {
        try {
        } catch (ex: Exception) {
            Log.e("DB_MIGRATION", "Error occurred: $ex")
        }
    }
}