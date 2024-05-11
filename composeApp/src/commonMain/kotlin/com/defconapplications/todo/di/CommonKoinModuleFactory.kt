package com.defconapplications.todo.di

import org.koin.dsl.module

object CommonKoinModuleFactory {
    fun create() = module {
        single { object : Test {} }
    }
}

interface Test