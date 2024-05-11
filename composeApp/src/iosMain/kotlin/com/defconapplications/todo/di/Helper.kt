package com.defconapplications.todo.di

import org.koin.core.context.startKoin

object Helper {
    fun initKoin() {
        startKoin {
            modules(
                CommonKoinModuleFactory.create()
            )
        }
    }
}