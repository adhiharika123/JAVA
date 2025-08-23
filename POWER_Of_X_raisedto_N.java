import java.util.*;
public class POWER_Of_X_raisedto_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x and n values : ");
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double power = pow(x,n);
        System.out.println("The result is : " + power);
    }

    //Naive Approch
    /* 
    public static double pow(double x, int n){
        double ans = 1.0;
        long power = n;
        if(power < 0){
            x = 1/x ;
            power = -power;
        }
        for(int i = 0 ; i < power ; i++){
            ans = ans * x;
        }
        return ans;
    }
    */

    //Optimal Approch - Binary Exponentiation
    //We reduce the number of multiplication operations needed to compute the power by breaking down the exponent to its half, smaller operations.
    public static double pow(double x, int n){
        double ans = 1.0;
        long nn = n;
        if(nn < 0){
            nn = -1 * nn;
        }
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }
            else{
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n < 0) ans = (double)1.0 / (double)ans;
        return ans;
    }
}
