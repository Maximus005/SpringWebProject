package dao;

import model.User;
import org.springframework.stereotype.Component;

import static dao.Repository.users;

//TODO replace cycles via streams

@Component
public class UserDaoImp implements UserDao {
    @Override
    public boolean SignIn(String email, String password) {
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean SignUp(String firstName, String lastName, String email, String password) {
        Integer userId = Repository.userId++;
        users.add(new User(userId, firstName, lastName, email, password));
        return false;
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
}