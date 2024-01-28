package HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {
    HashSet<Integer> hashset = new HashSet<Integer>(Arrays.asList(2,3,4,7));
    System.out.println(hashset);
    hashset.add(10);
    hashset.add(15);
    System.out.println(hashset);
    Iterator<Integer> it = hashset.iterator();
    while (it.hasNext()) {
        System.out.println(it.next());
    }
    System.out.println(hashset.size());
    hashset.clear();
    System.out.println(hashset.isEmpty());
        
    }
    
}
