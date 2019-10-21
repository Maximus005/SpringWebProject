package project.dao;

import project.model.Task;
import project.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Pseudo repo using for data storage
 */

public class Repository {

    public static int taskId;
    public static int userId;

    public static List<Task> tasks = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
}
