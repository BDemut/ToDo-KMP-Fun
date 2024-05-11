package com.defconapplications.todo.ui.home

import ViewTodoItem
import com.defconapplications.todo.domain.models.TodoItem

data class HomeState(
    val items: List<ViewTodoItem>
) {
    companion object {
        fun initial() = HomeState(items = emptyList())
    }
}