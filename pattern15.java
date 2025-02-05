//Hallow Butterfly
import java.util.*;
public class pattern15{
    public static void main(String args[]){
                   System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.print("*");    
            if(i>1){
                for(int j=1;j<=(i-2);j++)
                    System.out.print(" ");
                if(i>1){
                    System.out.print("*");
                }
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            if(i>1){
                for(int j=1;j<=(i-2);j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
    }

    for(int i=n;i>0;i--){
        System.out.print("*");
        if(i>1){
            for(int j=1;j<=(i-2);j++){
                System.out.print(" ");
            }
            if(i>1){
                System.out.print("*");
            }
        }
        for(int j=1;j<=2*(n-i);j++){
            System.out.print(" ");
        }
        System.out.print("*");
        if(i>1){
            for(int j=1;j<=(i-2);j++){
                System.out.print(" ");
            }
            System.out.print("*");
        }
        System.out.println();
    }
}
}

