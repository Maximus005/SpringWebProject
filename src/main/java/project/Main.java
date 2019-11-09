package project;

import LegacySecurityModule.SecurityModuleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import project.dao.TaskDaoJdbcImpl;
import project.dao.UserDaoJdbcImpl;
import project.model.User;
import project.model.UserRole;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true) //TODO ?!
public class Main {

    @Bean
    SecurityModuleImpl returnSecurityModuleImpl() {
        return new SecurityModuleImpl();
    }


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

        System.out.println(jdbcUser.securityModuleImpl.isAdmin("ADMIN"));

        jdbcTask.createTask("i12e6t3uwq456",2);

        User user = jdbcUser.createUser("aaIygor", "Kornaeluk", "akorno@mail.ru", "pass", UserRole.ADMIN);
        jdbcTask.deleteTaskByIdByUser(15,user);
    }
}