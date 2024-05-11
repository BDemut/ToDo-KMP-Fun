package com.defconapplications.todo.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            CommonKoinModuleFactory.create()
        )
    }
}