package Treemap;

import java.util.TreeMap;   

public class Treemap {
    public static void main(String[] args) {
    TreeMap<Integer,String> tmap = new TreeMap<Integer,String>();
    tmap.put(1,"black");
    tmap.put(2,"blue");
    tmap.put(3,"green");
    System.out.println("elements: "+ tmap);
    System.out.println("Searching element: "+ tmap.containsKey(2));
    System.out.println("Searching value: "+ tmap.containsValue("green"));
     System.out.println("All keys: "+ tmap.keySet());
}
}
