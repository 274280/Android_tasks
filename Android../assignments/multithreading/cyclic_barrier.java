
import java.util.concurrent.*;
import java.lang.Thread;

class shared_resource {
    int counter =0 ;

}

class thread_worker implements Runnable {
    CyclicBarrier cyclicBarrier;
    shared_resource  shared_resource;
    int id ;
    thread_worker(CyclicBarrier cyclicBarrier,int id) {
        this.cyclicBarrier= cyclicBarrier;
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("thread"+ id + "is incrementing counter");

            shared_resource.counter++;
            System.out.println("thread"+id+"reached cyclic barrier");

            cyclicBarrier.await();
        }
        catch(BrokenBarrierException  | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class cyclic_barrier {
    public static void main(String[] args) {
        shared_resource shared = new shared_resource();
        CyclicBarrier barrier = new CyclicBarrier(3);
        for(int i=0;i<3;i++) {
        Thread t =  new Thread(new thread_worker(barrier, i));
        t.start();
        }



    }
    
}
