//Butterfly Pattern
import java.util.*;
public class pattern13 {
    public static void main(String[] args) {
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        for(i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=(2*n)-(2*i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        for(i=1;i<=n;i++){
            for(int j=n-i;j>=0;j--){
                System.out.print("*");
            }
            for(int j=1;j<=(2*i)-2;j++){
                System.out.print(" ");
            }
            for(int j=n-i;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }   
}
