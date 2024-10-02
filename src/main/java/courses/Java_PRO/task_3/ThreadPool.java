package courses.Java_PRO.task_3;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> workers;
    private final LinkedList<Runnable> taskQueue;
    private boolean isShutdown;

    public ThreadPool(int capacity) {
        this.taskQueue = new LinkedList<>();
        this.workers = new LinkedList<>();
        this.isShutdown = false;

        for (int i = 0; i < capacity; i++) {
            Thread worker = new Thread(() -> {
                while (true) {
                    Runnable task;
                    synchronized (taskQueue) {
                        while (taskQueue.isEmpty()) {
                            if (isShutdown) return;
                            try {
                                taskQueue.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                        task = taskQueue.poll();
                    }
                    if (task != null) {
                        task.run();
                    }
                }
            });
            worker.start();
            workers.add(worker);
        }
    }

    public void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool has been shut down");
        }

        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void shutdown() {
        isShutdown = true;
        synchronized (taskQueue) {
            taskQueue.notifyAll();
        }
    }

    public void awaitTermination() {
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
