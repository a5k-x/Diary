package com.a5k.diary.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher

@Component(
    modules = [
        DatabaseModule::class,
        DispatcherModule::class,
        DataSourceModule::class
    ]
)
interface BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): BaseComponent
    }

    @IoDispatcher
    fun dispatcher(): CoroutineDispatcher
}
