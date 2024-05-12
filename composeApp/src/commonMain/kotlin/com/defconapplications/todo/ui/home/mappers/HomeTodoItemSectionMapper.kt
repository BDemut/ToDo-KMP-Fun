package com.defconapplications.todo.ui.home.mappers

import ViewTodoItem
import ViewTodoSection
import com.defconapplications.todo.domain.models.Deadline
import com.defconapplications.todo.domain.models.TodoItem
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime

class HomeTodoItemSectionMapper {
    fun map(items: List<TodoItem>): List<ViewTodoSection> {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        // set up an empty mutable list for each section
        val itemsArray = orderedSections.map {
            mutableListOf<ViewTodoItem>()
        }

        items.forEach { item ->
            val daysUntilDeadline = now.daysUntil(item.deadline.date)
            val section = orderedSections.indexOfFirst {
                it.days == null || daysUntilDeadline < it.days
            }
            itemsArray[section].add(ViewTodoItem(item.title, item.deadline.format()))
        }

        return itemsArray.mapIndexedNotNull { idx, items ->
            items.takeIf { it.isNotEmpty() }
                ?.let {
                    ViewTodoSection(orderedSections[idx].description, items.toList())
                }
        }
    }

    private fun Deadline.format(): String =
        when (this) {
            is Deadline.Date -> ""
            is Deadline.DateTime -> time.toString()
        }
}


private data class Section(val description: String, val days: Int?)

private val orderedSections = arrayOf(
    Section("Past due date!", 0),
    Section("Today", 1),
    Section("Tommorow", 2),
    Section("In two days", 3),
    Section("In three days", 4),
    Section("Within a week", 8),
    Section("Within two weeks", 15),
    Section("Within a month", 31),
    Section("Within two months", 61),
    Section("Within half a year", 183),
    Section("Within a year", 366),
    Section("More than a year", null),
)