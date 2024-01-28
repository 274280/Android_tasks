package files;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
public class file_directories {

     public static void main(String a[])
     {
        Scanner sc = new Scanner(System.in);
        String format = sc.nextLine();
        String path = sc.nextLine();
        File file = new File(path);
        String[] fileList = file.list();
        File[] files = file.listFiles();
        if(file.exists()) {
            System.out.println("path exists");
        }
        if(file.canRead()) {
            System.out.println("Read access is present");
        }
        if(file.canWrite()) {
            System.out.println("Write access is present");
        }

        if(file.isDirectory()) {
            System.out.println("Given path is a directory");
        }
        if(file.isFile()) {
            System.out.println("Given path is a file");
        }
        for(String name:fileList){
            System.out.println(name);
        }

        for(File fil:files) {
            if(fil.getName().toLowerCase().endsWith("."+format)) {
                System.out.println(fil.getName());
            }
            else 
            System.out.println("not found");
        }
    
}
}
