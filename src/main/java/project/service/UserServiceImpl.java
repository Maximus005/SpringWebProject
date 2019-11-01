package project.service;

import project.dao.TaskDaoImpl;
import project.dao.UserDaoImpl;
import project.dao.TaskStatus;
import project.model.Task;
import project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDaoImpl;

    @Override
    public User signUp(int userId, String firstName, String lastName,
                       String email, String password) {
        return userDaoImpl.createUser(userId, firstName, lastName, email, password);
    }

    @Override
    public User signIn(int userId) {
        return userDaoImpl.findUserById(userId);
    }

    @Override
    public boolean retire(int userId) {
        return userDaoImpl.deleteUserById(userId);
    }
}
