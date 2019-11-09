package project.dao;

import project.model.User;
import project.model.UserRole;

public interface UserDao {

    User createUser(String firstName, String lastName,
                        String email, String password, UserRole userRole);

    User findUserById(int userId);

    boolean deleteUserById(int userId);

    boolean updateUser(User user);

    boolean updateSubscriptionById(String hash, int id);
}
