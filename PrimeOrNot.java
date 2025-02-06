import java.util.*;
public class PrimeOrNot {

    public static void Prime(int n){
        if(n<=1){
            System.out.println("Given number is not a prime number...");
            return;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                System.out.println("Given number is not a prime number...");
                return;
            }
        }
        System.out.println("Given number is a prime number...");
    }
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Prime(n);
    }
}
