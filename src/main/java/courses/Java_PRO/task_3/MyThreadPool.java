package courses.Java_PRO.task_3;

import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {
    private final int capacity;
    //    private final List<Thread> workers;
    private final LinkedList<Runnable> taskQueue;
    private boolean isShutdown;

    public MyThreadPool(int capacity, LinkedList<Runnable> taskQueue) {
        this.capacity = capacity;
        this.taskQueue = taskQueue;

        for (int i = 0; i < capacity; i++) {
            int finalI = i;
            Thread worker = new Thread(() -> {
                while (true) {
                    Runnable task;
                    synchronized (taskQueue) {
                        if (taskQueue.isEmpty()) {
                            break; // Выход, если очередь пуста
                        }

                        task = taskQueue.poll(); // Получаем задачу из очереди
                    }


                        if (task != null) {
                            System.out.println("Работает поток " + finalI);
                            task.run(); // Запускаем задачу
                        }

                }
            });

            worker.start();
        }

    }

    public void run() {

    }
}
