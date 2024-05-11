package com.defconapplications.todo.di

import TodoRepository
import com.defconapplications.todo.ui.home.HomeScreenViewModel
import org.koin.dsl.module

object CommonKoinModuleFactory {
    fun create() = module {
        single { object : Test {} }

        single { TodoRepository() }

        factory { HomeScreenViewModel(
            repository = get()
        ) }
    }
}

interface Test