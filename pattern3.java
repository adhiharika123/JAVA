//Half Pyramid
import java.util.*;
public class pattern3 {
    public static void main(String[] args) {
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // for(int i = 1; i <= n; i++){
        //     for(int j = i; j <= (2*i)-1 ; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
