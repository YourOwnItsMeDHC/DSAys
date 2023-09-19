package Synchronization;

public class Synchron {
    public static void main(String[] args) {
        Tab t = new Tab();

        Childd t1 = new Childd(t, "First Thread");
        Childd t2 = new Childd(t, "Second Thread");
        Childd t3 = new Childd(t, "First Thread");
        Childd t4 = new Childd(t, "Second Thread");
        Childd t5 = new Childd(t, "First Thread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        //Implement stop function as well
    }
}


class Childd extends Thread {
    Tab t;
    private final String name;
    Childd(Tab t, String name) {
        this.t = t;
        this.name = name;
    }
    public void run() {
        t.printTable(5);
    }
}

class Table {
    synchronized void printTable (int n) {
        try {
            int count = 0;
            for(int i=1; i<=10; i++) {
                if(count >= 5000) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " - " + i + " second....");
                Thread.sleep(1000);
                count += 1000;
            }
        }
        catch(Exception e) {
            System.out.println("Exception Caught");
        }

    }
}
