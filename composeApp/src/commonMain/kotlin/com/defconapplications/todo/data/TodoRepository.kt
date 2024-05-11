import com.defconapplications.todo.domain.models.TodoItem
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month

class TodoRepository {
    val items = listOf(
        TodoItem("Task 1", LocalDateTime(2024, Month.DECEMBER, 1, 14, 30)),
        TodoItem("Task 2", LocalDateTime(2024, Month.MAY, 6, 7, 30)),
        TodoItem("Task 3", LocalDateTime(2024, Month.JUNE, 15, 10, 0,0))
    )
}