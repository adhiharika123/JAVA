import java.util.*;
public class MaxConsecutiveOnesIII{
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
        int result = longestOnes(nums, k);
        System.out.println("The Length of Longest Subarray with Maximum Consecutive Ones is : " + result);
    }
    //  Brute Force 
    /*
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            int zeroes = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == 0){
                    zeroes += 1;
                }
                if(zeroes > k){
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
    */

    //  Optimal Approach
    public static int longestOnes(int[] nums, int k){
        int n = nums.length;
        int left = 0;
        int right = 0;
        int zeroes = 0;
        int maxlen = 0;
        for(right = 0; right < n; right++){
            if(nums[right] == 0){
                zeroes++;
            }
            if(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}