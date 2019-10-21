package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.dao.Repository;
import project.dao.TaskDao;
import project.dao.TaskDaoImp;
import project.service.UserService;
import project.service.UserServiceImp;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Main.class);

        UserService userServiceImp = context.getBean(UserServiceImp.class);
        TaskDao taskDao = context.getBean(TaskDaoImp.class);

        System.out.println(userServiceImp
                .SingUp("Max", "Tarasov","email","1234"));

        System.out.println(Repository.users.get(0).getFirstName());
        System.out.println(taskDao.createTask(Repository.users.get(0),"Task#1"));
        System.out.println(Repository.tasks.get(0).getTaskName());
        System.out.println(taskDao.deleteTaskByName("Task#1"));
       // System.out.println(Repository.tasks.get(0).getTaskName());

    }

}