import java.util.*;
public class SumOfN {
    public static void SumofNatural(int n){
        int sum = 0;
        for(int i=0;i<=n;i++){
            sum = sum + i;
        }
        System.out.println("Sum of N :" + sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value:");
        int n = sc.nextInt();
        SumofNatural(n);
    }
}
