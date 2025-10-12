import java.util.*;
public class CountNumberOfNiceSubarrays{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        int result = numberOfSubarrays(nums, k);
        System.out.println("The number of nice subarrays are  : " + result);
    }

    //  BruteForce Approach
    /*
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int K = k;
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 1){
                    K--;
                }
                if(K == 0){
                    count++;
                }
            }
        }
        return count;
    }
    */

    //  Optimal Approach
    public static int numberOfSubarrays(int[] nums, int k){
        return atmost(nums, k) - atmost(nums, k-1);
    }
    public static int atmost(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            if(nums[right] % 2 == 1){
                k--;
            }
            while(k < 0){
                if(nums[left] % 2 == 1){
                    k++;
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
