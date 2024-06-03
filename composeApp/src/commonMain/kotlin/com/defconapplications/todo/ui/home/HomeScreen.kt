package com.defconapplications.todo.ui.home

import ViewTodoItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
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
        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = { AddItemButton() }
        ) {
            val state = viewModel.state.collectAsState().value
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                state.sections.forEach { section ->
                    item {
                        Card(
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                        ) {
                            Column {
                                SectionHeader(section.title)
                                for (item in section.items) {
                                    TodoItem(item)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = {
        Text("To do")
    })
}

@Composable
fun AddItemButton() {
    FloatingActionButton(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "add an item"
        )
    }
}

@Composable
fun SectionHeader(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        text = text
    )
}

@Composable
fun TodoItem(item: ViewTodoItem) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false, onCheckedChange = {}
        )
        Text(
            modifier = Modifier.weight(1f),
            text = item.title
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = item.deadline
        )
    }
}