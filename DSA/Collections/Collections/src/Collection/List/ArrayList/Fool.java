//package Collection.List.ArrayList;
//
//public class Fool {
//    public static void main(String[] args) {
//
//        Mult t1 = new Mult();
//        Mult t2 = new Mult();
//        Mult2 t3 = new Mult2();
//        Mult t4 = new Mult();
//        Mult t5 = new Mult();
//
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t4.setName("t4");
//        t5.setName("t5");
//
//        t1.start();
//        try{
//            t1.join(500);
//            t1.stop();
//
//            t2.start();
//            t2.join(500);
//            t2.stop();
//
//            t3.start();
//            t3.join(500);
//            t3.stop();
//
//            t4.start();
//            t4.join(500);
//            t5.stop();
//
//            t5.start();
//            t5.join(500);
//
//            System.out.println("Main thread is also terminated successfully");
//        }
//        catch (Exception e) {
//            System.out.println("Exception caught");
//        }
//
//
//    }
//}
//
//class Mult extends Thread {
//    public void run() {
//        for(int i=1;i<=4;i++){
//            try{
//                Thread.sleep(5000);
//            }catch(Exception e){
//                System.out.println(e);
//            }
//            System.out.println(i + " ==> I am " + Thread.currentThread().getName());
//        }
//    }
//
//    // for stopping the thread
//    public void stop()
//    {
//        exit = true;
//    }
//}
//
//class Mult2 extends Thread {
//    public void run() {
////        for(int i=1;i<=4;i++){
////            try{
////                Thread.sleep(8000);
////            }catch(Exception e){
////                System.out.println("Exception in thread : " + Thread.currentThread().getName());
////            }
////            System.out.println(i);
////        }
//        int i = 0;
//        while (!exit) {
//            System.out.println(name + ": " + i);
//            i++;
//            try {
//                Thread.sleep(100);
//            }
//            catch (InterruptedException e) {
//                System.out.println("Caught:" + e);
//            }
//        }
//        System.out.println(name + " Stopped.");
//    }
//
//    // for stopping the thread
//    public void stop()
//    {
//        exit = true;
//    }
//}

