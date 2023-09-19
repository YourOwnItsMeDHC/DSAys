package Collection.List.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Full {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            singleThreadExecutor.execute(task);
        }

        singleThreadExecutor.submit(() -> System.out.println("Hello Educative"));
        if(!singleThreadExecutor.isTerminated()){
            singleThreadExecutor.shutdown();
            if(singleThreadExecutor.awaitTermination(5, TimeUnit.SECONDS)) System.out.println("Executor service terminated successfully.");
            else System.out.println("Executor service termination unsuccessful.");
        }
    }
}

//package Collection.List.ArrayList;
//
//import java.time.LocalDateTime;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//public class Full {
//    public static void main(String[] args) {
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        for (int i = 1; i <= 5; i++) {
//            Task task = new Task("Task " + i);
//            executor.execute(task);
//        }
//
//        shutdownAndAwaitTermination(executor);
//    }
//
//    static void shutdownAndAwaitTermination(ExecutorService pool) {
//        // Disable new tasks from being submitted
//        pool.shutdown();
//        try {
//            // Wait a while for existing tasks to terminate
//            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
//                // Cancel currently executing tasks forcefully
//                pool.shutdownNow();
//                // Wait a while for tasks to respond to being cancelled
//                if (!pool.awaitTermination(5, TimeUnit.SECONDS))
//                    System.err.println("Pool did not terminate");
//            }
//        } catch (InterruptedException ex) {
//            // (Re-)Cancel if current thread also interrupted
//            pool.shutdownNow();
//            // Preserve interrupt status
//            Thread.currentThread().interrupt();
//        }
//    }
//}


class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000l);
            Thread.interrupted();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task [" + name + "] executed on : " + LocalDateTime.now().toString());
    }
}
