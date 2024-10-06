package courses.Java_PRO;


import courses.Java_PRO.task_2.CollectionService;
import courses.Java_PRO.task_3.MyThreadPool;
import courses.Java_PRO.task_3.ThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;

@SpringBootApplication
public class JavaProApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaProApplication.class, args);
//        TestRunner.runTests(SomeClass.class); // task_1
//        CollectionService collectionService = new CollectionService();
//        collectionService.run();


//        LinkedList<Runnable> tasks = new LinkedList<>();
//        for (int i = 0; i < 4; i++) {
//
//            tasks.add(new Runnable() {
//                @Override
//                public void run() {
//
//                    for (int j = 0; j < 5; j++) {
//
//                        System.out.println(j);
//                    }
//                }
//            });
//        }
//        MyThreadPool threadPool = new MyThreadPool(3, tasks);

        ThreadPool threadPool = new ThreadPool(3);
        
        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            threadPool.execute(() -> {
                System.out.println("Executing task " + taskNum + " in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination();
        System.out.println("All tasks completed and thread pool is shut down");

    }
}
