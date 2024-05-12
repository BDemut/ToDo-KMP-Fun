package com.defconapplications.todo.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel as AndroidViewModel
import androidx.lifecycle.viewModelScope as androidViewModelScope
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.compose.koinViewModel as androidKoinViewModel

actual abstract class ViewModel actual constructor() : AndroidViewModel() {
    actual val viewModelScope: CoroutineScope
        get() = androidViewModelScope
}

@Composable
actual inline fun <reified T : ViewModel> koinViewModel(): T {
    return androidKoinViewModel<T>()
}