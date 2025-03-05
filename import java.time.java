import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private String assignedTo;
    private String status;
    private LocalDateTime dueDate;

    public Task(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = "Pending";
        this.assignedTo = null;
    }

    public void assignTo(String teamMember) {
        this.assignedTo = teamMember;
    }

    public void updateStatus(String newStatus) {
        if (newStatus.equals("Pending") || newStatus.equals("In Progress") || newStatus.equals("Completed")) {
            this.status = newStatus;
        } else {
            throw new IllegalArgumentException("Invalid status");
        }
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate);
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAssignedTo() { return assignedTo; }
    public String getStatus() { return status; }
    public LocalDateTime getDueDate() { return dueDate; }
}
