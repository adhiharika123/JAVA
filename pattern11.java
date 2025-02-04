//Number Pyramid
import java.util.*;
public class pattern11 {
    public static void main(String args[]){
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row_count=1;

        for(int i=n;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=row_count;j++){
                System.out.print(row_count + " ");
            }
            System.out.println();
            row_count++;
        }

    }
}
