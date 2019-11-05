package project.service;

import project.model.TaskPriority;
import project.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(int taskId, String taskName, int userId);

    boolean deleteTaskById(int taskId);

    boolean markTaskAsFinishedById(int taskId);

    boolean markTaskAsUnFinishedById(int taskId);

    TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority);

    List<Task> findAllTasksByUserId(int userId);

    List<Task> findAllTasks();
}
