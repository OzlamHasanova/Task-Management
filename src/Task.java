import java.time.LocalDateTime;

public class Task {
private static Long lastId=0L;
    private Long id;
    private String name;
    private String description;
    private int priority;
    private TaskStatus status;
    private LocalDateTime deadline;

    public Task(Long id, String name, String description, int priority, TaskStatus status, LocalDateTime deadline) {
        this.id = ++lastId;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.deadline = deadline;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", deadline=" + deadline +
                '}';
    }
}
