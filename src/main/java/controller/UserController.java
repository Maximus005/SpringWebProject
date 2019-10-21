package controller;

import org.springframework.stereotype.Component;
import service.UserService;

@Component
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean SignIn(String email, String password) {
        return userService.SingIn(email, password);
    }

    public boolean SignUp(String firstName, String lastName, String email, String password) {
        return userService.SingUp(firstName, lastName, email, password);
    }


}
