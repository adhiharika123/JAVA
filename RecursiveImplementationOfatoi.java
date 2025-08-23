import java.util.*;
public class RecursiveImplementationOfatoi{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The String : ");
        String s = sc.next();
        int n = s.length();
        int num = atoi(s,n);
        System.out.println("The Integer Number is : " + num);
    }
    public static int atoi(String s, int n){
        if(s == " " || !s.matches("^\\d*$")){ //"^\\d*$" -> which are numeric values (0-9)
            return 0;
        }
        if(n == 1){
            return s.charAt(0) - '0';    //Converts first caharacter pof string to integer value
        }
        return(10 * atoi(s,n-1) + s.charAt(n-1) - '0');
    }
}