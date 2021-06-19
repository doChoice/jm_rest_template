package net.stupkin;

import net.stupkin.configuation.AppConfig;
import net.stupkin.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<User> users = communication.getUsers();
        System.out.println(users);

        User user = new User(3L, "James", "Brown", (byte)23);
        communication.saveUser(user);

        user.setName("Thomas");
        user.setLastName("Shelby");
        communication.updateUser(user);

        communication.deleteUser(3L);

        System.out.println("Code: " + communication.getCode());
    }
}
