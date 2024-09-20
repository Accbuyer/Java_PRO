package courses.Java_PRO;


import courses.Java_PRO.task_2.CollectionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaProApplication.class, args);
//        TestRunner.runTests(SomeClass.class); // task_1
        CollectionService collectionService = new CollectionService();
        collectionService.run();

    }
}
