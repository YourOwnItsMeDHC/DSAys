package JavaTask;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Fairness {
    public static void main(String[] args) {
        Table t = new Table();

//        Chi t1 = new Chi(t);
//        Chi t2 = new Chi(t);
//        Chi t3 = new Chi(t);>>>>>>>>
//        Chi t4 = new Chi(t);
//        Chi t5 = new Chi(t);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            Task task = new Task(t, "Thread " + i);
            singleThreadExecutor.execute(task);
        }

        System.out.println("👋👋");
    }
}


class Task implements Runnable {
    private final String name;
    Table t;
    Task(Table t, String name) {
        this.t = t;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task [" + name + "] started its execution at : " + LocalDateTime.now().toString());
            t.printTable(5);
        System.out.println(name + " is getting killed 👋👋");
        System.out.println("Task [" + name + "] is killed at : " + LocalDateTime.now().toString());
        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥");


    }
}

//class Chi extends Thread {
//    Table t;
//    Chi(Table t) {
//        this.t = t;
//    }
//    public void run() {
//        t.printTable(5);
//    }
//}

class Table {

    synchronized void printTable (int n) {
        try {
            int count = 0;
            for(int i=1; i<=10; i++) {
                if(count >= 5000) {
                    break;
                }

                System.out.println(i + " second....");
                Thread.sleep(1000);
                count += 1000;
            }
        }
        catch(Exception e) {
            System.out.println("Exception Caught");
        }
    }

}
