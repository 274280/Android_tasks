import java.util.*;
import java.util.concurrent.locks.*;

class Shared_resource {
    int counter = 0;
    Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
        counter++;
        System.out.println("Thread " + Thread.currentThread().getId() + " incremented the counter to: " + counter);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        finally {
            lock.unlock();
        }
    }
}


class Thread_source implements Runnable {
Shared_resource shared_resource;
public Thread_source(Shared_resource shared_resource) {
    this.shared_resource=shared_resource;
}
public void run() {
    try {
        for(int i=0;i<=10;i++) {

        shared_resource.increment();
        }
    }
    catch(Exception e) {}
    }

}

public class Reentrant_lock {
    public static void main(String[] args) {
        Shared_resource shared_resource = new Shared_resource();
        Runnable r1 = new Thread_source(shared_resource);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch(Exception e) {}
    }
    
}
