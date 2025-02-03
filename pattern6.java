//Half Pyramid with numbers
import java.util.*;
public class pattern6 {
    public static void main(String[] args) {
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j + " ");
            } 
            System.out.println();
        }
    }
}
