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
        TodoItem("Task 3", Deadline.Date(LocalDate(2024, Month.JUNE, 15))),
        TodoItem("Task 4", Deadline.Date(LocalDate(2024, Month.JUNE, 16))),
        TodoItem("Task 5", Deadline.Date(LocalDate(2024, Month.JUNE, 16))),
        TodoItem("Task 6", Deadline.Date(LocalDate(2024, Month.JUNE, 1))),
        TodoItem("Task 7", Deadline.Date(LocalDate(2024, Month.JUNE, 2))),
        TodoItem("Task 8", Deadline.Date(LocalDate(2024, Month.JUNE, 3)))
    )
}