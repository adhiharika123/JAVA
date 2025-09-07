import java.util.*;
public class DivideTwoIntegers {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The dividend value is : ");
        int dividend = sc.nextInt();
        System.out.println("The divisor value is : ");
        int divisor = sc.nextInt();
        int result = divide(dividend,divisor);
        System.out.println("The Quotient is : " + result);
    }
    public static int divide(int dividend, int divisor) {
        //Naive Approach
        /*
        boolean negative = (divisor < 0) ^ (dividend < 0);  //Checking for sign 
        long a = Math.abs((long) dividend);     //Convert to long
        long b = Math.abs((long) divisor);
        long quotient = 0;
        while(a >= b){
            a = a-b;            //Subtracting divisor from dividend each time
            quotient++;         //Keep track of quotient to check specified conditions
        }
        quotient = negative ? -quotient : quotient; 
        if(quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)quotient;
        */

        //Optimal Approach
        if(dividend == divisor){
            return 1;
        }
        boolean sign = true;
        if(dividend >= 0 && divisor < 0) sign = false;
        else if(dividend < 0 && divisor > 0) sign = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;
        while(n >= d){
            int cnt=0;
            while(n >= (d << (cnt+1)))
            {
                cnt++;
            }
            quotient += 1L << cnt;
            n = n - (d << cnt);
        }
        if(quotient > Integer.MAX_VALUE){
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(sign ? quotient : -quotient);
    }
}
