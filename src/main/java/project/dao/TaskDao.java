package project.dao;

import project.model.Task;
import project.model.TaskPriority;

import java.util.List;

public interface TaskDao {

    Task createTask(String taskName, int userId);

    boolean deleteTaskById(int taskId);

    boolean markTaskAsFinishedById(int taskId);

    boolean markTaskAsUnFinishedById(int taskId);

    TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority);

    List<Task> findAllTasksByUserId(int userId);

    List<Task> findAllTasks();

    Task findTaskById(int taskId);

    Task findTaskByName(String name);
}
