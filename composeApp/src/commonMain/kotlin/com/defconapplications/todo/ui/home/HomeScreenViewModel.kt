package com.defconapplications.todo.ui.home

import TodoRepository
import ViewTodoItem
import com.defconapplications.todo.utils.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel(
    val repository: TodoRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState.initial())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                items = repository.items.map { item ->
                    ViewTodoItem(item.title, item.deadline.toString())
                }
            )
        }
    }
}