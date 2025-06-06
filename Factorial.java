import java.util.*;
public class Factorial {
    public static int factorial(int n){
        if(n<=0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value:");
        int n = sc.nextInt();
        System.out.println("The Factorial of a given number is :" + factorial(n));
    }
}
