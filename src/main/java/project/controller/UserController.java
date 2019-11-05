package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;
import project.model.UserRole;
import project.service.UserService;


@Component
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User signUp(String firstName, String lastName,
                       String email, String password, UserRole userRole) {
        userService.signUp(firstName, lastName, email, password, userRole);
        return null;
    }

    public User signIn(int userId) {
        return userService.signIn(userId);
    }

    public boolean deleteUserById(int userId) {
        return userService.deleteUserById(userId);
    }

    public String addSubscriptionToUserById(int userId) {
       return userService.addSubscriptionToUserById(userId);
    }

    public boolean deleteSubscriptionFromUserById(int userId) {
       return userService.deleteSubscriptionFromUserById(userId);
    }
}
