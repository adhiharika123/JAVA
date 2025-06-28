import java.util.*;
public class SquareRoot{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.print("The Square Root of given n value is : " + floorSqrt(n));
    }
    //Sqrt() Function
    /* 
    public static int floorSqrt(int n){
        int ans = (int) Math.sqrt(n);
        return ans;
    }
    */

    //Binary Search 
    public static int floorSqrt(int n){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high) / 2;
            int val = mid * mid;
            if(val <= (long) n){
                low = (int) mid + 1;
            }else{
                high = (int) mid - 1;
            }
        }
        return high;
    }
}