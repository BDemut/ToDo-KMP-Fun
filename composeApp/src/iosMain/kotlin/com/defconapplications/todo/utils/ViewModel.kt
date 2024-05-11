package com.defconapplications.todo.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.MainScope
import org.koin.compose.getKoin

actual abstract class ViewModel {
    actual val viewModelScope = MainScope()
}

@Composable
actual inline fun <reified T : ViewModel> koinViewModel(): T {
    val koin = getKoin()
    return remember { koin.get<T>() }
}