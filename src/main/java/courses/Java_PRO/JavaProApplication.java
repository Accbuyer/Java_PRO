package courses.Java_PRO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaProApplication.class, args);
        TestRunner.runTests(SomeClass.class);

    }
}
