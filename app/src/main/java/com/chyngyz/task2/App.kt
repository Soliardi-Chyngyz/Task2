package com.chyngyz.task2

import android.app.Application
import com.chyngyz.task2.servicelocator.networkModule
import com.chyngyz.task2.servicelocator.repositoriesModule
import com.chyngyz.task2.servicelocator.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelsModule, repositoriesModule, networkModule)
        }
    }
}