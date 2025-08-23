/*A digit string is good if the digits (0-indexed) at even indices are even 
and the digits at odd indices are prime (2, 3, 5, or 7). */

import java.util.*;
public class CountGoodNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        long n = sc.nextLong();
        int goodNumbers = countGoodNumbers(n);
        System.out.println("The Total Good Numbers are : " + goodNumbers);

    }

    //Naive Approach 
    /* 
    public static int countGoodNumbers(long n) {
        int count = 0 ;
        int limit = (int) Math.pow(10, n);
        for(int i = 0 ; i < limit ; i++){
            String num = String.format("%0" + n + "d",i);    // Padding with leading zeroes
            if(isGood(num)){
                count += 1;
            }
        }
        return count;
    }
    public static boolean isGood(String num){
        for(int i = 0 ; i < num.length() ; i++){
            int digit =num.charAt(i) - '0';
            if(i % 2 == 0){
                if(digit != 0 && digit != 2 && digit != 4 && digit != 6 && digit != 8){
                    return false;
                }
            }
            else{
                if(digit != 2 && digit != 3 && digit != 5 && digit != 7){
                    return false;
                }
            }
        }
        return true;
    }
    */

    //Optimal Approch - Binary Exponentiation

    public static final long MOD = 1_000_000_007L;
    public static int countGoodNumbers(long n){
        long evencount = (n+1)/2;
        long oddcount = (n)/2;
        long partOne = midPow(5,evencount,MOD);
        long partTwo = midPow(4,oddcount,MOD);
        return (int)((partOne * partTwo) % MOD);
    }
    public static long midPow(long base, long exp , long mod){
        long res = 1;
        base = base % mod;
        while(exp > 0){
            if((exp & 1)== 1){
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1 ;     //Dividing by 2
        }
        return res;
    }
}
