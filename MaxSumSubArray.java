import java.util.Arrays;
import java.util.Scanner;

public class MaxSumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The sum of the largest subarray is :" + Subarray(nums,n));
    }
    public static int Subarray(int nums[], int n){

        //Approch 1: BruteForce TC:O(N^3)
        /*
        int max=Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int sum=0;
                for( int k = i ; k <= j ; k++){
                    sum += nums[k];
                }
                if(sum > max){
                    max=sum;
                }
            }
        }
        return max;
        */

        //Approch 2: Better Approch TC:O(N^2)
        /*
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0 ;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
        */

        //Approch 3 : Optimal TC:O(N)
        int current_sum=nums[0];
        int max_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            current_sum=Math.max(nums[i],current_sum+nums[i]);
            max_sum=Math.max(max_sum,current_sum);
        }
        return max_sum;
        
    }
}
