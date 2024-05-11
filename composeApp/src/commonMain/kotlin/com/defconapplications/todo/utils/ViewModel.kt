package com.defconapplications.todo.utils

import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    val viewModelScope: CoroutineScope
}

@Composable
expect inline fun <reified T : ViewModel> koinViewModel(): T