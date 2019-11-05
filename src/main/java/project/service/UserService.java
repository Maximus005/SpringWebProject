package project.service;

import project.model.User;
import project.model.UserRole;

public interface UserService {
    User signUp(String firstName, String lastName,
                String email, String password, UserRole userRole);

    User signIn(int userId);

    boolean deleteUserById(int userId);

    String addSubscriptionToUserById(int userId);

    boolean deleteSubscriptionFromUserById(int userId);
}
