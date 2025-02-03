//Inverted Half Pyramid with numbers
import java.util.*;
public class pattern7 {
    public static void main(String[] args) {
        System.out.println("Enter n value:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print((j+ " "));
            }
            System.out.println();
        }

    }
}
