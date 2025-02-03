//Hallow Rectangle
import java.util.*;
public class pattern2 {
    public static void main(String[] args) {
        System.out.println("Enter n valaue");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i <n; i++){
            for(int j =0; j <m; j++){
                if(i == 0 || j == 0|| i == n-1 ||j == m-1){
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
