class counter {
    int counter = 0;
    public synchronized void increment() {
        counter++;
    }
}

public class shared_counter {
    public static void main(String[] args) {
        counter  counter = new counter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
            for(int i=0;i<100;i++) {
                counter.increment();
            }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
            for(int i=0;i<100;i++) {
                counter.increment();
            }
            }
        });
        t1.start();
        t2.start();
        System.out.println(counter.counter);

    }
    
}
