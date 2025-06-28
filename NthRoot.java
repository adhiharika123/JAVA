import java.util.Scanner;

public class NthRoot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter m value:");
        int m = sc.nextInt();
        System.out.print("The Nth Root of given n value is : " + Root(n, m));
    }
    //Linear Search
    /* 
    public static int Root(int n, int m){
        for(int i = 1 ; i <= n ; i++){
            long val = func(i,n);
            if(val == (long) m) return i;
            else if(val >= (long) m) break;
        }
        return -1;
    }
    */

    public static int Root(int n, int m){
        int low = 1;
        int high = m;
        while(low <= high){
            int mid = (low + high) /2;
            long midPow = power(mid,n);
            if(midPow == m) return mid;
            else if(midPow < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static long power(int b, int exp){
        int ans = 1;
        int base = b;
        while(exp > 0){
            if(exp % 2 == 1){
                exp--;
                ans = ans * base;
            }
            else{
                exp /= 2;
                base = base * base;
            }
        }
        return ans;
    }
}
