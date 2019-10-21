package service;

import model.Status;
import model.Task;
import model.User;

import java.util.List;

public interface UserService {
    boolean SingIn(String email, String password);

    boolean SingUp(String firstName, String lastName, String email, String password);

    boolean deleteUserByEmail(String email);

    boolean createTask(User user, String taskName);

    boolean deleteTaskByName(String taskName);

    boolean setStatusByName(String taskName, Status status);

    List<Task> findAllTasksByEmail(String email);
}
