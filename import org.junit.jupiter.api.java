import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Design UI", "Create UI for dashboard", LocalDateTime.now().plusDays(2));
        assertEquals("Design UI", task.getTitle());
        assertEquals("Create UI for dashboard", task.getDescription());
        assertEquals("Pending", task.getStatus());
        assertNull(task.getAssignedTo());
    }

    @Test
    public void testAssignTo() {
        Task task = new Task("Fix bug", "Resolve login issue", LocalDateTime.now().plusDays(1));
        task.assignTo("Alice");
        assertEquals("Alice", task.getAssignedTo());
    }

    @Test
    public void testUpdateStatus() {
        Task task = new Task("Write API", "Develop REST API", LocalDateTime.now().plusDays(3));
        task.updateStatus("In Progress");
        assertEquals("In Progress", task.getStatus());

        task.updateStatus("Completed");
        assertEquals("Completed", task.getStatus());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.updateStatus("Unknown");
        });
        assertEquals("Invalid status", exception.getMessage());
    }

    @Test
    public void testIsOverdue() {
        Task task = new Task("Submit Report", "Prepare and submit report", LocalDateTime.now().minusDays(1));
        assertTrue(task.isOverdue());

        Task task2 = new Task("New Feature", "Implement new feature", LocalDateTime.now().plusDays(1));
        assertFalse(task2.isOverdue());
    }
}
