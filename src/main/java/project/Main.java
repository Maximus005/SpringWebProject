package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import project.dao.TaskDaoJdbcImpl;
import project.dao.UserDaoJdbcImpl;
import project.model.TaskPriority;

@Configuration
@ComponentScan(value = "project")
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        //TaskController taskController = context.getBean(TaskController.class);
        //UserController userController = context.getBean(UserController.class);

        //userController.signUp("Igor", "Korneluk", "korn@mail.ru", "pass", UserRole.ADMIN);

        UserDaoJdbcImpl jdbcUser = context.getBean(UserDaoJdbcImpl.class);
        TaskDaoJdbcImpl jdbcTask = context.getBean(TaskDaoJdbcImpl.class);

        //jdbcTask.createTask("задача 1234", 3);
        jdbcTask.deleteTaskById(8);
        jdbcTask.findAllTasks().forEach(System.out::println);


    }
}