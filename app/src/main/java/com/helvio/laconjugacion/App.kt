package com.helvio.laconjugacion

import android.app.Application
import com.helvio.laconjugacion.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(AppModule.module)
        }
    }
}
