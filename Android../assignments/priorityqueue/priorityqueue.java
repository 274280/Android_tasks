package priorityqueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<String> pqueue = new PriorityQueue<>(Arrays.asList("black","yellow"));
        PriorityQueue<String> p2 = new PriorityQueue<>();
        pqueue.add("blue");
        pqueue.add("white");
        System.out.println(pqueue);
        Iterator<String> it = pqueue.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        p2 = pqueue;
        System.out.println("Second queue: "+ p2);
        pqueue.clear();
        System.out.println("queue is empty: "+ pqueue);
    }
    
}
