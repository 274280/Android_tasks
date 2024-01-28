import java.util.*;

interface add {
     int Sum(int a, int b);
     
}


public class sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        String s2 = s.nextLine();
        add res = (int a,int b)->{int c =a+b;
        return c;};
        System.out.println(res.Sum(x,y));
        
    }
}

