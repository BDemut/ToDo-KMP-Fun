package com.defconapplications.todo.domain.models

import kotlinx.datetime.LocalDateTime

data class TodoItem(
    val title: String,
    val deadline: LocalDateTime
)