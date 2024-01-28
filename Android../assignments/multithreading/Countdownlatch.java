import java.lang.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
class thread_worker extends Thread {
    CountDownLatch latch;
    String string;
    public thread_worker(CountDownLatch latch, String string) {
        this.latch = latch;
        this.string = string;
    }

        public void run() {
            try {
            System.out.println("Thread"+Thread.currentThread().getName()+ "started");
            Thread.sleep(1000);
            latch.countDown();
            }
             catch (InterruptedException e) 
        { 
            e.printStackTrace(); 
        }
        }
    }


public class Countdownlatch {
    public static void main(String[] args) {
    
     CountDownLatch latch = new CountDownLatch(2); 
    thread_worker t1 = new thread_worker(latch,"t1");
    thread_worker t2 = new thread_worker(latch,"t2");

    t1.start();
    t2.start();
    try {
    latch.await();
    } catch(InterruptedException e) {
        System.out.println(e.getMessage());

    }

    System.out.println(Thread.currentThread().getName() + 
                           " has finished"); 
    }
    
}
