package com.defconapplications.todo.ui.home

import ViewTodoItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.defconapplications.todo.ui.theme.TodoTheme
import com.defconapplications.todo.utils.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    TodoTheme {
        val state = viewModel.state.collectAsState().value
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.sections.forEach { section ->
                item { SectionHeader(section.title) }
                items(section.items) { item ->
                    TodoItem(item)
                }
            }
        }
    }
}

@Composable
fun SectionHeader(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = text
    )
}

@Composable
fun TodoItem(item: ViewTodoItem) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = item.title
        )
        VerticalDivider()
        Text(item.deadline)
    }
}