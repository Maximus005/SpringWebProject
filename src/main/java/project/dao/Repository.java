package project.dao;

import project.model.Task;
import project.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Pseudo repo using for data storage
 */

@Component
public class Repository {

    static int taskId;
    static int userId;

    static List<Task> tasks = new ArrayList<>();
    static List<User> users = new ArrayList<>();
}
