package project.service;

import project.dao.UserDao;
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

    UserDao userDaoJdbcImpl;

    @Autowired
    public UserServiceImpl(UserDaoJdbcImpl userDaoJdbcImpl) {
        this.userDaoJdbcImpl = userDaoJdbcImpl;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String password, UserRole userRole) {
        return userDaoJdbcImpl.createUser(firstName, lastName, email, password,  userRole);
    }

    @Override
    public User findUserById(int userId) {
        return userDaoJdbcImpl.findUserById(userId);
    }

    @Override
    public boolean deleteUserById(int userId) {
        return userDaoJdbcImpl.deleteUserById(userId);
    }

    @Override
    public boolean updateUser(User user) {
        return updateUser(user);
    }

    @Override
    public boolean addSubscriptionToUserById(int id) {
        String hash = null;
        try {
            hash = generateHashForSubscription(algorithmName, subscription);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDaoJdbcImpl.updateSubscriptionById(hash, id);
    }

    private String generateHashForSubscription(String algorithmName, String stringForCoding)
            throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithmName);
        md.update(stringForCoding.getBytes());
        return DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
    }

    @Override
    public boolean deleteSubscriptionFromUserById(int id) {
        return userDaoJdbcImpl.updateSubscriptionById("", id);
    }
}
