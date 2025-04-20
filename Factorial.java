import java.util.*;
public class Factorial {

    public static void fact(int n){
        if(n<0){
            System.out.println("Invalid Number....Please Enter Valid Number");
            return;  //return -> used to come out or return to main as none
        }
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial = factorial *i;
        }
        System.out.println(factorial);
        return ;
    }

    public static void main(String[] args) {
        System.out.println("Enter n value: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fact(n);
    }
}


OR

//Recursion
import java.util.*;
public class Main {
    public static int fact(int n){
        if(n<0){
            System.out.println("Invalid..");
            return -1;
        }
        if(n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n value");
        int n=sc.nextInt();
        System.out.println("The factorial of a given number is :" + fact(n));
    }
}
