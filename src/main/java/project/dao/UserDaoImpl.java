package project.dao;

import project.model.User;
import org.springframework.stereotype.Component;

import static project.dao.Repository.users;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public User createUser(int userId, String firstName, String lastName,
                           String email, String password) {
        User newUser = new User(userId, firstName, lastName, email, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User findUserById(int userId) {
        return users.stream()
                    .filter(user -> user.getId() == userId)
                    .findFirst().get();
    }

    @Override
    public boolean deleteUserById(int userId) {
        users.remove(users.stream().filter(user -> user.getId() == userId).findFirst().get());
        return true;
    }
}