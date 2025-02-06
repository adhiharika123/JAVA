import java.util.Scanner;

public class SumOfOdd {
    public static void SumOfOdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {  
            if (i % 2 != 0) {  
                sum += i;
            }
        }
        System.out.println("Sum of odd numbers up to " + n + " is: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n value: ");
        int n = sc.nextInt();
        SumOfOdd(n);
    }
}
