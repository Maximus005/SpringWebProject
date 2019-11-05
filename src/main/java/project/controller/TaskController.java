package project.controller;

import project.model.TaskPriority;
import project.model.Task;
import project.service.TaskService;

import java.util.List;

//@Component
public class TaskController {
    private TaskService taskService;

    //@Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

}
