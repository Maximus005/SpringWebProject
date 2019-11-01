package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.controller.TaskController;
import project.controller.UserController;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

    }
}