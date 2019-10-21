package project.dao;
//TODO sing in/up, create/delete/ task, find all my task, mark as finished or unfinished.

import project.model.Status;
import project.model.Task;
import project.model.User;

import java.util.List;

/**
 * Interface for working with DataBase for Task projwct.model.
 * */

public interface TaskDao {
    //should return True, if Task created and False if Task already exist in repo
    // or some  another reason
    boolean createTask(User user, String taskName);

    //Should return True if delete was successful, and False otherwise.
    boolean deleteTaskByName(String taskName);

    //Should return True if status setting was successful, and False otherwise.
    boolean setStatusByName(String taskName, Status status);

    //Returns list of tasks for particular user that have email.
    List<Task> findAllTasksByEmail(String email);
}
