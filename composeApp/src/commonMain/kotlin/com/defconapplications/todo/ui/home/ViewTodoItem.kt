data class ViewTodoItem(
    val title: String,
    val deadline: String
)

data class ViewTodoSection(
    val title: String,
    val items: List<ViewTodoItem>
)