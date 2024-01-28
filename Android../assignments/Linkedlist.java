import java.util.*;

public class Linkedlist {
public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(1,6,3,4,8));
    System.out.println("Initializing Linkedlist: "+ll);
    ll.add(9);
    System.out.println("Iterating alal the elements: ");
    Iterator it = ll.iterator();
    while(it.hasNext()) {
        System.out.println(it.next());
    }
    ListIterator lit = ll.listIterator(2);
    System.out.print("iterating from specified position: ");
    while(lit.hasNext()) {
        System.out.println(lit.next());
    }
    System.out.println("iterating in reverse order: ");
    while(lit.hasPrevious()) {
        System.out.println(lit.previous());
    }
    System.out.println("retrieving first and last elements: "+ll.peekFirst() + ","+ll.peekLast());
    System.out.println("adding elements at first and last and specified positions: ");
    ll.addFirst(10);
    ll.addLast(40);
    ll.add(4,23);
    System.out.println(ll);
}    
}
