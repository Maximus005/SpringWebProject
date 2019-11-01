package project.service;

import project.dao.TaskPriority;
import project.dao.TaskStatus;
import project.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(int taskId, String taskName, int userId);

    boolean deleteTaskById(int taskId);

    TaskStatus setTaskStatusById(int taskId, TaskStatus taskStatus);

    TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority);

    List<Task> findAllTasksByUserId(int userId);

    List<Task> findAllTasks();
}
