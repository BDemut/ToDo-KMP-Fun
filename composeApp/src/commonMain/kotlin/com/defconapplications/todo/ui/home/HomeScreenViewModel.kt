package com.defconapplications.todo.ui.home

import TodoRepository
import com.defconapplications.todo.ui.home.mappers.HomeTodoItemSectionMapper
import com.defconapplications.todo.utils.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel(
    val repository: TodoRepository,
    val mapper: HomeTodoItemSectionMapper
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState.initial())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                sections = mapper.map(repository.items)
            )
        }
    }
}