package project.dao;

import project.model.Task;

import java.util.List;

public interface TaskDao {

    Task createTask(int taskId, String taskName, int userId);

    boolean deleteTaskById(int taskId);

    TaskStatus setTaskStatusById(int taskId, TaskStatus taskStatus);

    TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority);

    List<Task> findAllTasksByUserId(int userId);

    List<Task> findAllTasks();
}
