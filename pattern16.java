//Hallow Rhombus
import java.util.*;
public class pattern16 {
    public static void main(String args[]){
        System.out.println("Enter n a value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i == 1 || j == 1|| i == n ||j == n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println(); 
            
        }
    }
}
    

