package com.abrar.thecocktailapps.core.app

import android.app.Application
import androidx.multidex.MultiDex
import com.abrar.thecocktailapps.core.di.module.AppModule
import com.abrar.thecocktailapps.core.di.module.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}