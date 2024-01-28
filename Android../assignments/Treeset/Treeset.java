package Treeset;

import java.util.Arrays;
import java.util.*;

public class Treeset {
    public static void main(String[] args) {
        TreeSet<String> tset = new TreeSet<String>(Arrays.asList("black","white","yellow"));
        TreeSet<String> treeset = new TreeSet<String>();
        System.out.println(tset);
        tset.add("violet");
        tset.add("red");
        System.out.println(tset);
        Iterator<String> it = tset.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        treeset = tset;
        System.out.println(treeset);
        System.out.println("Reverse view: "+tset.descendingSet());
    }
    
    }
    

