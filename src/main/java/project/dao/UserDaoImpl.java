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

    //TODO (1) м.б. если юзер не найден то  кидать исключение ?
    @Override
    public User updateUser(int userId, User userForUpdate) {
        for (User user : users) {
            if(user.getId()  == userId) {
                user.setSubscription(userForUpdate.getSubscription());
                user.setEmail(userForUpdate.getEmail());
                user.setFirstName(userForUpdate.getFirstName());
                user.setLastName(userForUpdate.getLastName());
                user.setPassword(userForUpdate.getPassword());
                return user;
            }
        }
        return null;
    }

}