import com.defconapplications.todo.domain.models.Deadline
import com.defconapplications.todo.domain.models.TodoItem
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.Month

class TodoRepository {
    val items = listOf(
        TodoItem("Task 1", Deadline.Date(LocalDate(2024, Month.DECEMBER, 1))),
        TodoItem("Task 2", Deadline.DateTime(LocalDate(2024, Month.MAY, 6), LocalTime(7, 30))),
        TodoItem("Task 3", Deadline.Date(LocalDate(2024, Month.JUNE, 15)))
    )
}