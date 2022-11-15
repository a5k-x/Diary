package com.a5k.diary

import android.app.Application
import com.a5k.diary.di.BaseComponent
import com.a5k.diary.di.DaggerBaseComponent

class App: Application() {

    private lateinit var appComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerBaseComponent.factory().create(applicationContext)
    }
}