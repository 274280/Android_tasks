import java.util.*;

//import java.util.stream.Stream;

public class avgofnum {
    public static void main(String[] args) {
    List<Integer> list = Arrays.asList(6,4,7,9,2,5,7,4);
    List<String> list1 = Arrays.asList("sai","kiran","anil","charan");
    //System.out.println(list.size());
    System.out.println(list.stream().mapToInt(Integer::intValue).average());
    list1.stream().forEach(n->{System.out.println(n.toUpperCase());});
    System.out.println(list1.stream().filter(n-> n.charAt(0) == 'a').count());
    




    
    }
    
}
