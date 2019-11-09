package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.service.TaskService;

import java.util.List;

@Component
public class TaskController {
    private TaskService taskServiceImpl;

    @Autowired
    public TaskController(TaskService taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }


}
