package exception_handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;


class exception_handler extends Exception{
    public  exception_handler(String str) {
        super(str);
    }
}


public class exceptions {
    public static void printodd(int num) {
    try {
        if(num%2 != 0) 
         throw new exception_handler("oddnumber");
         else
         System.out.println(num);
    }
    catch(exception_handler e) {
        e.printStackTrace();
    }
}
public static void filereader(String str) throws FileNotFoundException {
    FileReader file = new FileReader(str);
    BufferedReader reader = new BufferedReader(file);
    String data = null;
    StringBuilder string = new StringBuilder();
    try {
        while((data = reader.readLine())!=null) {
            string.append(data);
            System.out.println("File contains"+data);
        }
        if(string.length()==0){
            throw new exception_handler("File is empty");
        }
    }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        catch(exception_handler e) {
            System.out.println(e.getMessage());
        }

}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    String filename = sc.nextLine();
    printodd(a);
    try {
    filereader(filename);
    }catch(FileNotFoundException e) {
        System.out.println(e.getMessage());
    }

    }
    
}
