package project.service;

import project.dao.TaskStatus;
import project.model.Task;
import project.model.User;

import java.util.List;

public interface UserService {
    User signUp(int userId, String firstName, String lastName,
                    String email, String password);

    User signIn(int userId);

    boolean retire(int userId);
}
