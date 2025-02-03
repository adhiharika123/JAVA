import java.util.*;
public class pattern4 {
    public static void main(String[] args) {
        System.out.println("Enter n value: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // for(int i = 0; i < n; i++){
        //     for(int j = i; j < n ;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        for(int i = n; i > 0; i-- ){
            for(int j = 1; j <= i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
