package com.defconapplications.todo.ui.home

import ViewTodoItem
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.defconapplications.todo.utils.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    MaterialTheme {
        val state = viewModel.state.collectAsState().value
        LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            items(state.items) {
                TodoItem(it)
            }
        }
    }
}

@Composable
fun TodoItem(item: ViewTodoItem) {
    Row {
        Text("${item.title}, ${item.deadline}")
    }
}