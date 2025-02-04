//Solid Rhombus
import java.util.*;
public class pattern10{
    public static void main(String args[]){
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=i;j<=((2*n)-1);j++){
                if(j<n){
                    System.out.print(" "+" ");
                }
                else{
                    System.out.print("*"+" ");
                }
            }
            System.out.println();
        }
    }
}
