package courses.Java_PRO;


import courses.Java_PRO.task_2.CollectionService;
import courses.Java_PRO.task_3.ThreadPool;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import courses.Java_PRO.task_4.User;
import courses.Java_PRO.task_4.config.DataSourceConfig;
import courses.Java_PRO.task_4.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedList;
import java.util.List;

//@SpringBootApplication
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

        Thread.sleep(5000000);
    }
//        SpringApplication.run(JavaProApplication.class, args);
//        TestRunner.runTests(SomeClass.class); // task_1
//        CollectionService collectionService = new CollectionService();
//        collectionService.run();
//
//        ThreadPool threadPool = new ThreadPool(3);
//
//        for (int i = 0; i < 10; i++) {
//            int taskNum = i;
//            threadPool.execute(() -> {
//                System.out.println("Executing task " + taskNum + " in thread " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            });
//        }
//
//        threadPool.shutdown();
//        threadPool.awaitTermination();
//        System.out.println("All tasks completed and thread pool is shut down");


    }

