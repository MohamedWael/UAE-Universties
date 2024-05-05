package com.mowael.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mowael.core.data.UniversityDto

private const val DB_VERSION = 2

@Database(entities = [UniversityDto::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDao

    companion object {
        const val DATABASE_NAME = "university-database"
        fun createDatabase(applicationContext: Context) =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()

    }
}
