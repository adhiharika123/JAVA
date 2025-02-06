import java.util.*;
;public class EvenOrOdd {
    public static void Even_Odd(int n){
        if(n%2==0){
            System.out.println("Given number is Even....");
            return;
        }
        else{
            System.out.println("Given number is odd....");
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Even_Odd(n);
    }
}
