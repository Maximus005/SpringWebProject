package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.service.UserService;
import project.service.UserServiceImp;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Main.class);

        UserService userServiceImp = context.getBean(UserServiceImp.class);

        System.out.println(userServiceImp
                .SingUp("Max", "Tarasov","email","1234"));

    }
}