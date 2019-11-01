package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;
import project.service.UserService;

@Component
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User signUp(int userId, String firstName, String lastName,
                       String email, String password) {
        return userService.signUp(userId, firstName, lastName, email, password);
    }

    public User signIn(int userId) {
        return userService.signIn(userId);
    }

    public boolean retire(int userId) {
        return userService.retire(userId);
    }
}
