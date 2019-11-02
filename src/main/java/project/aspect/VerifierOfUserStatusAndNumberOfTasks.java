package project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;
import project.service.TaskServiceImpl;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static project.dao.Repository.users;
import static project.service.Security.algorithmName;
import static project.service.Security.subscription;

@Aspect
@Component

public class VerifierOfUserStatusAndNumberOfTasks {
    @Autowired
    TaskServiceImpl taskService;

    @Pointcut("execution(* project.dao.TaskDao.createTask(..))")
    public void handle() {}

    @Before("handle()")
    public void aspect(JoinPoint joinPoint) {
        try {
            Integer userId = (Integer) joinPoint.getArgs()[2];
            for (User user : users) {
                if(user.getId() == userId) {
                    String localValueOfSubscription = DatatypeConverter
                            .printHexBinary(MessageDigest.getInstance(algorithmName).digest(subscription.getBytes()));
                    if(!user.getSubscription().equals(localValueOfSubscription) && taskService.findAllTasksByUserId(userId).size() > 10) {
                        throw new RuntimeException("User has free account and can not add more than 10 tasks");
                    }
                }
            }
        } catch (NoSuchAlgorithmException exp) { System.out.println(exp); }
    }
}
