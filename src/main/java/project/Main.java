package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import project.controller.TaskController;
import project.controller.UserController;
import project.model.Task;
import project.model.User;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static project.dao.Repository.users;
import static project.service.Security.algorithmName;
import static project.service.Security.subscription;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        TaskController taskController = context.getBean(TaskController.class);
        UserController userController = context.getBean(UserController.class);

        userController.signUp(1,"Max","Tarasov"
                             ,"email","p");
        //userController.addSubscriptionToUserById(1);

        taskController.createTask(1,"task1",1);
        taskController.createTask(2,"task2",1);
        taskController.createTask(3,"task2",1);
        taskController.createTask(4,"task2",1);
        taskController.createTask(5,"task2",1);
        taskController.createTask(6,"task2",1);
        taskController.createTask(7,"task2",1);
        taskController.createTask(8,"task1",1);
        taskController.createTask(9,"task2",1);
        taskController.createTask(10,"task2",1);
        taskController.createTask(11,"task2",1);
        taskController.createTask(12,"task2",1);

        System.out.println(users.get(0).toString());

        //taskController.findAllTasksByUserId(1).forEach(System.out::println);


    }
}