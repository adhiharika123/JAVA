//Solid Rectangle
import java.util.*;
public class pattern1 {
    public static void main(String args[]){
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i<=n ; i++){
            for(int j =0; j<=n ;j++){
                System.out.print("*" + " ");
            }
        System.out.println(" ");
        }

    }
}
