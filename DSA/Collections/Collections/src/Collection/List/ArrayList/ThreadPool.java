package Collection.List.ArrayList;

public class ThreadPool {
    public static void main(String[] args) {

        Multi t1 = new Multi();
        Multi t2 = new Multi();
        Multi t3 = new Multi();
        Multi t4 = new Multi();
        Multi t5 = new Multi();


        try{
            t1.setName("t1");
            t1.start();

            t2.setName("t2");
            t2.start();
            t1.join(5);

            t3.setName("t3");
            t3.start();
            t2.join(5);

            t4.setName("t4");
            t4.start();
            t3.join(5);

            t5.setName("t5");
            t5.start();

        }
        catch(Exception e) {
            System.out.println("Exception Caught");
        }


    }
}

class Multi extends Thread {
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
