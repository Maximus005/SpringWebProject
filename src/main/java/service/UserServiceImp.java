package service;

//import dao.TaskDaoImp;
//import dao.UserDaoImp;
import dao.TaskDaoImp;
import dao.UserDao;
import dao.UserDaoImp;
import model.Status;
import model.Task;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImp implements UserService {

    @Autowired
    UserDaoImp userDaoImp;

    @Autowired
    TaskDaoImp taskDaoImp;

    @Override
    public boolean SingIn(String email, String password) {
        return  userDaoImp.SignIn(email, password);
    }

    @Override
    public boolean SingUp(String firstName, String lastName, String email, String password) {
        return userDaoImp.SignUp(firstName, lastName, email, password);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        return userDaoImp.deleteUserByEmail(email);
    }

    @Override
    public boolean createTask(User user, String taskName) {
        return taskDaoImp.createTask(user, taskName);
    }

    @Override
    public boolean deleteTaskByName(String taskName) {
        return taskDaoImp.deleteTaskByName(taskName);
    }

    @Override
    public boolean setStatusByName(String taskName, Status status) {
        return taskDaoImp.setStatusByName(taskName, status);
    }

    @Override
    public List<Task> findAllTasksByEmail(String email) {
        return taskDaoImp.findAllTasksByEmail(email);
    }
}
