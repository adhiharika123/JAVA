/*You are given an integer array nums. The range of a subarray of nums is the difference between the largest and
smallest element in the subarray.Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array. */

import java.util.*;

public class SumofSubArrayRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n valaue : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        long result = subArrayRanges(arr);
        System.out.println("The sum of sub array ranges is : " + result);
    }
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++){
            int mini = nums[i];
            int maxi = nums[i];
            for(int j = i; j < n; j++){
                mini = Math.min(mini, nums[j]);
                maxi =   Math.max(maxi, nums[j]);
                sum += (maxi - mini);
            }
        }
        return sum;
    }
}
