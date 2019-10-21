import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;
import service.UserServiceImp;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext();
        context.refresh();

    UserService userServiceImp = context.getBean(UserServiceImp.class);

        System.out.println(userServiceImp
                .SingUp("Max", "Tarasov","email","1234"));

    }
}
