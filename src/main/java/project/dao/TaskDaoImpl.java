package project.dao;

import project.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static project.dao.Repository.tasks;

@Component
public class TaskDaoImpl implements TaskDao{

    @Override
    public Task createTask(int taskId, String taskName, int userId) {
        Task newTask = new Task(taskId, taskName, userId);
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public boolean deleteTaskById(int taskId) {
        tasks.remove(tasks.stream().filter(task -> task.getId() == taskId).findFirst().get());
        return true;
    }

    @Override
    public TaskStatus setTaskStatusById(int taskId, TaskStatus taskStatus) {
        tasks.stream().filter(task -> task.getId() == taskId).findFirst().get().setTaskStatus(taskStatus);
        return taskStatus;
    }

    @Override
    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        tasks.stream().filter(task -> task.getId() == taskId)
                      .findFirst().get().setTaskPriority(taskPriority);
        return taskPriority;
    }

    @Override
    public List<Task> findAllTasksByUserId(int userId) {
        return tasks.stream().filter(task -> task.getUserId() == userId)
                             .collect(Collectors.toList());
    }

    @Override
    public List<Task> findAllTasks() {
        return tasks;
    }


}
