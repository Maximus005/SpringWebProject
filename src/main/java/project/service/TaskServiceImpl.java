package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.dao.TaskDao;
import project.dao.TaskDaoJdbcImpl;
import project.model.TaskPriority;
import project.model.Task;
import project.model.User;

import java.util.List;

@Component
public class TaskServiceImpl implements TaskService{

    TaskDao taskDaoJdbcImpl;

    @Autowired
    public TaskServiceImpl(TaskDao taskDaoJdbcImpl) {
        this.taskDaoJdbcImpl = taskDaoJdbcImpl;
    }

    @Override
    public Task createTask(String taskName, int userId) {
        return taskDaoJdbcImpl.createTask(taskName, userId);
    }

    @Override
    public boolean deleteTaskById(int taskId) {
        return taskDaoJdbcImpl.deleteTaskById(taskId);
    }

    @Override
    public boolean deleteTaskByIdByUser(int taskId, User user) {
        return taskDaoJdbcImpl.deleteTaskByIdByUser(taskId, user);
    }

    @Override
    public boolean markTaskAsFinishedById(int taskId) {
        return taskDaoJdbcImpl.markTaskAsFinishedById(taskId);
    }

    @Override
    public boolean markTaskAsUnFinishedById(int taskId) {
        return taskDaoJdbcImpl.markTaskAsUnFinishedById(taskId);
    }

    @Override
    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        return taskDaoJdbcImpl.setTaskPriorityById(taskId, taskPriority);
    }

    @Override
    public List<Task> findAllTasksByUserId(int userId) {
        return taskDaoJdbcImpl.findAllTasksByUserId(userId);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskDaoJdbcImpl.findAllTasks();
    }

    @Override
    public Task findTaskById(int taskId) {
        return taskDaoJdbcImpl.findTaskById(taskId);
    }

    @Override
    public Task findTaskByName(String name) {
        return taskDaoJdbcImpl.findTaskByName(name);
    }
}
