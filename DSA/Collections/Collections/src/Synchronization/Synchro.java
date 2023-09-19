package Synchronization;

public class Synchro {
    public static void main(String[] args) {
        Tab t = new Tab();

        Child t1 = new Child(t);
        Child t2 = new Child(t);
        Child t3 = new Child(t);

        t1.start();
        t2.start();
        t3.start();
    }
}


class Child extends Thread {
    Tab t;
    Child(Tab t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

class Tab {
  synchronized void printTable (int n) {
        try {
            for(int i=1; i<=5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + n + " X " + i + " = " + (n*i));
                Thread.sleep(1000);
            }
        }
        catch(Exception e) {
            System.out.println("Exception Caught");
        }

    }
}
