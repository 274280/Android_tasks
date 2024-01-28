import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

interface StringCheck {
    boolean checkEmpty(String s);
}
interface caseconverter {
    String caseconvert(String str);
}
interface sort {
    String sorting(String str);
}
interface Duplicate {
    Set<Integer> removedup(ArrayList<Integer> arr);
}
interface concatenate {
    String concatenateString(String str,String str2);
}
interface factorialnum {
    Integer fact(Integer num);
}

class CheckEmptyString {


    public static void checkingemptystring (String str) {

        StringCheck checkEmpty = string -> string.isEmpty();

        if (checkEmpty.checkEmpty(str)) {
            System.out.println("The entered string is empty.");
        } else {
            System.out.println("The entered string is not empty.");
        }
    }

    public static void toupper(String str) {
        caseconverter caseconvert = string->string.toUpperCase();
        System.out.println(caseconvert.caseconvert(str));
        
    }

    public static void tolower(String str) {
        caseconverter caseconv = string->string.toLowerCase();
        System.out.println(caseconv.caseconvert(str));
        
    }
    public static void Sort(String str) {
        sort sort = (string)->{
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            return new String(arr);};
    }
    public static Set<Integer> removedupl(ArrayList<Integer> arr) {
        Duplicate duplicate = (ArrayList<Integer> array)->{Set<Integer> set = new HashSet<Integer>();
        for(int i: arr) {
            set.add(i);
        }
        return  set;};
        return duplicate.removedup(arr);
    }
    
    public static Integer factorial(Integer n1) {
        factorialnum number =(Integer num)-> {
            Integer res=1;
            while(num >0) {
                res = num*res;
                num--;

            }
            return res;
        };
        return number.fact(n1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(2,23,4,6,2,8,4,6,7,3,1,9,4));
       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        String inpuString2 = scanner.nextLine();
        Integer a = scanner.nextInt();
        
       concatenate con = (String s1, String s2)-> {
        return s1+s2;
       };
        factorialnum number =(Integer num)-> {
            Integer res=1;
            while(num >0) {
                res = num*res;
                num--;

            }
            return res;
        };


        checkingemptystring(inputString);
        tolower(inputString);
        toupper(inputString);
        Sort(inputString);
        System.out.println(removedupl(arr));
        System.out.println(con.concatenateString(inputString, inpuString2));
        System.out.println(factorial(a));
        
    }
}

