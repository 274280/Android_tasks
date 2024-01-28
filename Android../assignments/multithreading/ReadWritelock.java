import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class shared_resource {
    int counter;

    public void readdata(ReadWriteLock readWriteLock) {
        readWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getId() +": " + counter);
            } finally {
                readWriteLock.readLock().unlock();
            }
    }
    
        public void writeData(ReadWriteLock readWriteLock) {
            readWriteLock.writeLock().lock();
            try {
                int newData = counter + 1;
                System.out.println("Writedata"+ Thread.currentThread().getId()+": "  + newData);
                counter = newData;
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

}
class Thread_worker implements Runnable {
    ReadWriteLock readWriteLock;
    shared_resource resource ;
    public Thread_worker(shared_resource resource,ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
        this.resource = resource;
    }
    public void run() {
        resource.readdata(readWriteLock);
        resource.writeData(readWriteLock);
    }
}

public class ReadWritelock {

    public static void main(String[] args) {
         ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
         shared_resource resource = new shared_resource();

         for(int i=0;i<3;i++) {
            Thread t1 = new Thread(new Thread_worker(resource,readWriteLock));
            t1.start();
         }

    }
    
}
