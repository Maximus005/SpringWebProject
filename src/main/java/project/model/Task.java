package project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import project.dao.TaskPriority;
import project.dao.TaskStatus;

import java.time.LocalDate;

@Getter
@Setter
public class Task {

    private int id;
    private String taskName;
    private TaskStatus taskStatus;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private int userId;
    private TaskPriority taskPriority;

    public Task(int id, String taskName, int userId) {
        this.id = id;
        this.userId = userId;
        this.taskName = taskName;
        this.taskStatus = TaskStatus.IN_PROGRESS;
        this.taskPriority = TaskPriority.MEDIUM;
        this.startTime = LocalDate.now();
    }

    public void setStartTime() {
        this.startTime = LocalDate.now();
    }
    public void setEndTime() {
        this.endTime = LocalDate.now();
    }
}