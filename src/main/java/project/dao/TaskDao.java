package project.dao;

import project.model.Task;
import project.model.TaskPriority;
import project.model.User;

import java.util.List;

public interface TaskDao {

    Task createTask(String taskName, int userId);

    boolean deleteTaskById(int taskId);

    /**
     * Method using just for demonstration LegacySecurityModule class and  corresponding AOP class.
     * An exception will be thrown if the user is not an admin
     */
    boolean deleteTaskByIdByUser(int taskId, User user);

    boolean markTaskAsFinishedById(int taskId);

    boolean markTaskAsUnFinishedById(int taskId);

    TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority);

    List<Task> findAllTasksByUserId(int userId);

    List<Task> findAllTasks();

    Task findTaskById(int taskId);

    Task findTaskByName(String name);


}
