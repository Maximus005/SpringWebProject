package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.dao.TaskPriority;
import project.dao.TaskStatus;
import project.model.Task;
import project.service.TaskService;

import java.util.List;

@Component
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public Task createTask(int taskId, String taskName, int userId) {
        return taskService.createTask(taskId, taskName,userId);
    }

    public boolean deleteTaskById(int taskId) {
        return taskService.deleteTaskById(taskId);
    }

    public TaskStatus setTaskStatusById(int taskId, TaskStatus taskStatus) {
        return taskService.setTaskStatusById(taskId, taskStatus);
    }

    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        return taskService.setTaskPriorityById(taskId, taskPriority);
    }

    public List<Task> findAllTasksByUserId(int userId) {
        return taskService.findAllTasksByUserId(userId);
    }

    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }
}
