package dao;

import model.Status;
import model.Task;
import model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static dao.Repository.tasks;
import static dao.Repository.users;

//TODO rewrite cycles via streams

@Component
public class TaskDaoImp implements TaskDao{

    @Override
    public boolean createTask(User user, String taskName) {
        Integer taskId = Repository.taskId++;
        return tasks.add(new Task(taskId, user, taskName, Status.IN_PROGRESS));
    }

    @Override
    public boolean deleteTaskByName(String taskName) {
        for (Task task : tasks) {
            if(task.getTaskName().equals(taskName)) {
                return tasks.remove(task);
            }
        }
        return false;
    }

    @Override
    public boolean setStatusByName(String taskName, Status status) {
        for (Task task : tasks) {
            if(task.getTaskName().equals(taskName)) {
                task.setStatus(status);
            }
        }
        return false;
    }

    @Override
    public List<Task> findAllTasksByEmail(String email) {
        List<Task> allTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(task.getUser().getEmail().equals(email)) {
                allTasks.add(task);
            }
        }
        return null;
    }
}
