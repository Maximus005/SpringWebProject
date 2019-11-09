package project.service;

import project.model.User;
import project.model.UserRole;

public interface UserService {

    User createUser(String firstName, String lastName,
                    String email, String password, UserRole userRole);

    User findUserById(int userId);

    boolean deleteUserById(int userId);

    boolean updateUser(User user);

    boolean addSubscriptionToUserById(int id);

    boolean deleteSubscriptionFromUserById(int id);
}
