//Pascal's Triangle
import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args) {
        System.out.println("Enter the n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // Print leading spaces for alignment
            for (int j = 0; j <n - i; j++) {
                System.out.print(" ");
            }
            int num=1;
            for(int j=0;j<=i;j++){
                System.out.print(num+" ");
                num=num*(i-j)/(j+1);
            }
            System.out.println();
        }
    }
}
