//Floyd's Triangle
import java.util.*;
public class pattern8 {
    public static void main(String[] args) {
        System.out.println("Enter n value");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number =1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
