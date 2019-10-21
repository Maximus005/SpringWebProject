package project.dao;

//TODO sing in/up, create/delete/ task, find all my task, mark as finished or unfinished.

/**
 * Interface for working with DataBase for User projwct.model.
 * */

public interface UserDao {
    //Should return True if SignIn was successful
    boolean SignIn(String email, String password);

    //Should return True if SignUp was successful
    boolean SignUp(String firstName, String lastName, String email, String password);

    //Should return True if deleting was successful
    boolean deleteUserByEmail(String email);
}
