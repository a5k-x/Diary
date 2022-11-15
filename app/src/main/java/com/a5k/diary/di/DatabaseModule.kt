package com.a5k.diary.di

import android.content.Context
import com.a5k.diary.data.database.AppDatabase
import dagger.Module
import dagger.Provides


@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(appContext: Context): AppDatabase = AppDatabase.getDatabase(appContext)
}
