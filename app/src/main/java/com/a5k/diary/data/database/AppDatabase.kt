package com.a5k.diary.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.a5k.diary.data.datasource.TaskDao
import com.a5k.diary.data.model.TaskDb

@Database(
    entities = [TaskDb::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        private var instance: AppDatabase? = null
        private const val NAME_DB = "task_table"

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(applicationContext: Context) =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, NAME_DB)
                .build()
    }

}