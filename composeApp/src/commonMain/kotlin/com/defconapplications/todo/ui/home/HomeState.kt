package com.defconapplications.todo.ui.home

import ViewTodoItem
import ViewTodoSection
import com.defconapplications.todo.domain.models.TodoItem

data class HomeState(
    val sections: List<ViewTodoSection>
) {
    companion object {
        fun initial() = HomeState(sections = emptyList())
    }
}