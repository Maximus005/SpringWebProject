package project.dao;

import project.model.User;

import java.util.Optional;

public interface UserDao {

    User createUser(int userId, String firstName, String lastName,
                        String email, String password);

    User findUserById(int userId);

    boolean deleteUserById(int userId);
}
