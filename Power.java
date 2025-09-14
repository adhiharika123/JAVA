import java.util.*;
public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x value : ");
        double x = sc.nextDouble();
        System.out.println("Enter n(power) value : ");
        int n = sc.nextInt();
        double ans = myPow(x, n);
        System.out.println("The Power of a given x to n is : " + ans);

    }
    /* 
    public static double myPow(double x, int n) {
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
    
    public static double myPow(double x, int n){
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
