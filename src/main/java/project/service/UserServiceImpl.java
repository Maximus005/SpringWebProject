package project.service;

import project.dao.UserDaoImpl;
import project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

import static project.dao.Repository.users;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDaoImpl;

    @Override
    public User signUp(int userId, String firstName, String lastName,
                       String email, String password) {
        return userDaoImpl.createUser(userId, firstName, lastName, email, password);
    }

    @Override
    public User signIn(int userId) {
        return userDaoImpl.findUserById(userId);
    }

    @Override
    public boolean retire(int userId) {
        return userDaoImpl.deleteUserById(userId);
    }

    //TODO (3) лучше возвращать булеан, стрингу хэшкода или... И что делать если юзер не найден ?
    // Как лучше ставить блок try: локально илиболее глобально?
    @Override
    public String addSubscriptionToUserById(int userId) {
        String hash = null;
        for(User user : users) {
            if(user.getId() == userId) {
                try {
                    hash = generateHashForSubscription(Security.algorithmName, Security.subscription);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                user.setSubscription(hash);
                return hash;
            }
        }
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
        for(User user : users) {
            if(user.getId() == userId) {
                user.setSubscription("");
                return true;
            }
        }
        return false;
    }
}
