package hashmap;

import java.util.HashMap;

public class hashmap {
    public static void main(String[] args) {
         HashMap<Integer,String> hashmap = new HashMap<>();
          HashMap<Integer,String> hashmap2 = new HashMap<>();
         hashmap.put(1,"Black");
         hashmap.put(2,"blue");
         hashmap.put(3,"green");

         System.out.println("elements: "+ hashmap);
         System.out.println("Size: "+ hashmap.size());
         hashmap2 = hashmap;
         System.out.println("elements in secomnd map: "+ hashmap);
        hashmap.clear();
        System.out.println(hashmap.isEmpty());

    }
    
}
