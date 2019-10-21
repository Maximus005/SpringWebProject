package dao;

import model.Task;
import model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Pseudo repo using for data storage
 */

@Component
public class Repository {

    static Integer taskId;
    static Integer userId;

    static List<Task> tasks = new ArrayList<>();
    static List<User> users = new ArrayList<>();
}
