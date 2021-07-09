package net.stupkin;

import net.stupkin.configuation.AppConfig;
import net.stupkin.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerRestClient customerRestClient = context.getBean("customerRestClient", CustomerRestClient.class);

        List<User> users = customerRestClient.getUsers();
        System.out.println(users);

        User user = new User(3L, "James", "Brown", (byte)23);
        customerRestClient.saveUser(user);

        user.setName("Thomas");
        user.setLastName("Black");
        customerRestClient.updateUser(user);

        customerRestClient.deleteUser(3L);

        System.out.println("Code: " + customerRestClient.getCode());
    }
}
