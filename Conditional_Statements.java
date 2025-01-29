// //Program to check a person is Adult or Not 
    import java.util.*;
    public class Conditional_Statements {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Age value");
            int age = sc.nextInt();
            
            if(age>18){
                System.out.println("ADULT");
            } else{
                System.out.println("NOT ADULT");
            }
        }
    }

//Program to check a number is Even or Odd
import java.util.*;
public class Conditional_Statements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        int num = sc.nextInt();
        if(num%2==0){
            System.out.println("EVEN");
        } else{
            System.out.println("ODD");
        }
    }
}

//Program on If-Else
import java.util.*;
public class Conditional_Statements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int a = sc.nextInt();
        System.out.println("Enter b number");
        int b = sc.nextInt();
        if(a==b){
            System.out.println("A equals to B");
        } else{
            if(a>b){
                System.out.println("A greater than B");
            }
            else{
                System.out.println("A lesser than B");
            }
        }
    }
}