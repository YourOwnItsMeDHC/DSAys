package MultiThread;
public class Interrupt {
    public static void main(String[] args) {
        Child t = new Child();
        t.start();

        //As here, it is in the sleeping state
        //The moment we call the interrupt()
        //It will get interrupted
        //and will throw InterruptedException
        //and will enter into the catch block
        t.interrupt();

        System.out.println("Child Thread is interrupted : " + t.isInterrupted());
        for(int i=1; i<=5; i++) {
            System.out.println("Main Thread");
        }
    }
}

class Child extends Thread {
    public void run() {

        //Below thread will execute the entire loop
        //and still interrupt does not have any effect
        //as our thread is still not in sleeping or waiting state
        for(int i=1; i<=10; i++) {
            System.out.println("Child Thread");
        }
        try {

            //Now, thread is in sleeping state
            //The moment thread comes into the sleeping state
            //interrupt() will interrupt it
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Child got interrupted");
        }
    }
}
