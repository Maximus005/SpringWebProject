package project.service;

import project.model.TaskPriority;
import project.model.Task;

import java.util.List;

//@Component
public class TaskServiceImpl implements TaskService{

    @Override
    public Task createTask(int taskId, String taskName, int userId) {
        return null;
    }

    @Override
    public boolean deleteTaskById(int taskId) {
        return false;
    }

    @Override
    public boolean markTaskAsFinishedById(int taskId) {
        return false;
    }

    @Override
    public boolean markTaskAsUnFinishedById(int taskId) {
        return false;
    }

    @Override
    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        return null;
    }

    @Override
    public List<Task> findAllTasksByUserId(int userId) {
        return null;
    }

    @Override
    public List<Task> findAllTasks() {
        return null;
    }
}
