package com.defconapplications.todo

import android.app.Application
import com.defconapplications.todo.di.AppKoinModuleFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ToDoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(androidContext = this@ToDoApplication)
            modules(
                AppKoinModuleFactory.create()
            )
        }
    }
}