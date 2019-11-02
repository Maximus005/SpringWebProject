package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.controller.TaskController;
import project.controller.UserController;
import project.model.Task;
import project.model.User;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

        userController.signUp(1,"Max","Tarasov"
                             ,"email","p");
        taskController.createTask(1,"task1",1);
        taskController.createTask(2,"task2",1);

        System.out.println();

        taskController.findAllTasksByUserId(1).forEach(System.out::println);

    }
}