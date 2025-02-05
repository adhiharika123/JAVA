//Inverted Half Pyramid
import java.util.*;
public class pattern19 {
    public static void main(String[] args) {
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=n;j>=i;j--){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
