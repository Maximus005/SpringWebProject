package project.service;

import project.dao.UserDaoJdbcImpl;
import project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.UserRole;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoJdbcImpl userDaoJdbc;

    @Override
    public User signUp(String firstName, String lastName,
                       String email, String password, UserRole userRole) {
        userDaoJdbc.createUser(firstName, lastName, email, password, userRole);
        return null;
    }

    @Override
    public User signIn(int userId) {
        return null;
    }

    @Override
    public boolean deleteUserById(int userId) {
        return false;
    }


    //TODO (3) лучше возвращать булеан, стрингу хэшкода или... И что делать если юзер не найден ?
    // Как лучше ставить блок try: локально илиболее глобально?
    @Override
    public String addSubscriptionToUserById(int userId) {
        String hash = null;

        return null;
    }

    //TODO (2)
    private String generateHashForSubscription(String algorithmName, String stringForCoding)
                                                                          throws Exception {
            MessageDigest md = MessageDigest.getInstance(algorithmName);
            md.update(stringForCoding.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
    }

    @Override
    public boolean deleteSubscriptionFromUserById(int userId) {

        return false;
    }
}
