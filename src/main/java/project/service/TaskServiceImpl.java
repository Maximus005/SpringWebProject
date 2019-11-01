package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import project.dao.TaskDaoImpl;
import project.dao.TaskPriority;
import project.dao.TaskStatus;
import project.model.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskDaoImpl taskDaoImpl;

    @Override
    public Task createTask(int taskId, String taskName, int userId) {
        return taskDaoImpl.createTask(taskId, taskName,userId);
    }

    @Override
    public boolean deleteTaskById(int taskId) {
        return taskDaoImpl.deleteTaskById(taskId);
    }

    @Override
    public TaskStatus setTaskStatusById(int taskId, TaskStatus taskStatus) {
        return taskDaoImpl.setTaskStatusById(taskId, taskStatus);
    }

    @Override
    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        return taskDaoImpl.setTaskPriorityById(taskId, taskPriority);
    }

    @Override
    public List<Task> findAllTasksByUserId(int userId) {
        return taskDaoImpl.findAllTasksByUserId(userId);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskDaoImpl.findAllTasks();
    }
}
