package project.service;

import project.dao.UserDaoJdbcImpl;
import project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.UserRole;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

import static project.service.Security.algorithmName;
import static project.service.Security.subscription;

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
    @Override
    public String addSubscriptionToUserById(int id) {
        String hash = "";
        try {
            hash = generateHashForSubscription(algorithmName, subscription);
        } catch (Exception e) { e.printStackTrace(); }

        userDaoJdbc.updateSubscriptionById(hash, id);

        return hash;
    }

    //TODO (2)
    private String generateHashForSubscription(String algorithmName, String stringForCoding)
                                                                          throws Exception {
            MessageDigest md = MessageDigest.getInstance(algorithmName);
            md.update(stringForCoding.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
    }

    @Override
    public boolean deleteSubscriptionFromUserById(int id) {
        userDaoJdbc.updateSubscriptionById("", id);
        return true;
    }
}
