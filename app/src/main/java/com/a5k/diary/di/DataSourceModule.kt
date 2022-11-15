package com.a5k.diary.di

import com.a5k.diary.data.datasource.DataSource
import com.a5k.diary.data.datasource.DataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun getDataSource(impl: DataSourceImpl): DataSource
}