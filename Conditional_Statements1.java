//Program on If Else-If
import java.util.*;
public class Conditional_Statements1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int a = sc.nextInt();
        System.out.println("Enter b number");
        int b = sc.nextInt();
        if(a==b){
            System.out.println("A equals to B");
        } 
        else if(a>b)
        {
                System.out.println("A greater than B");
        }
        else
        {
                System.out.println("A lesser than B");
        }
    }
        
}

