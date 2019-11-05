package project.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Task {

    private int id;
    private String taskName;
    private LocalDate dateOfFinished;
    private String description = "";
    private int userId;
    private TaskPriority taskPriority;
    private boolean status;

    public Task(String taskName, int userId) {
        this.userId = userId;
        this.taskName = taskName;
        this.taskPriority = TaskPriority.MEDIUM;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", dateOfFinished=" + dateOfFinished +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", taskPriority=" + taskPriority +
                ", status=" + status +
                '}';
    }
}