package project.aspect;

import LegacySecurityModule.SecurityModuleImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;

@Aspect
@Component
public class Security {

    @Autowired
    public SecurityModuleImpl securityModuleImpl;

    @Pointcut("execution(* project.dao.TaskDao.deleteTaskByIdByUser(..)))")
    void handle(){}

    @Before("handle()")
    public void advice(JoinPoint joinPoint) throws Exception{
        User user = (User) joinPoint.getArgs()[1];
        if(securityModuleImpl.isAdmin(user.getUserRole().toString())) {
            return;
        }
        throw new Exception("User does not have permissions for this operation");
    }



}
