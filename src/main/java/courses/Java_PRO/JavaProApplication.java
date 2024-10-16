package courses.Java_PRO;


import courses.Java_PRO.task_2.CollectionService;
import courses.Java_PRO.task_3.ThreadPool;
import courses.Java_PRO.task_4.User;
import courses.Java_PRO.task_4.config.DataSourceConfig;
import courses.Java_PRO.task_4.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedList;
import java.util.List;

@ComponentScan
public class JavaProApplication {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaProApplication.class);
        UserService userService = context.getBean(UserService.class);

        // Примеры операций
        User newUser = userService.createUser("john_doe");
        System.out.println("Created User: " + newUser.getUsername());

        User retrievedUser = userService.getUser(newUser.getId());
        System.out.println("Retrieved User: " + retrievedUser.getUsername());

        List<User> allUsers = userService.getAllUsers();
        System.out.println("All Users: ");
        for (User user : allUsers) {
            System.out.println(user.getUsername());
        }

        userService.deleteUser(newUser.getId());
        System.out.println("Deleted User with ID: " + newUser.getId());
        
    }



    }

