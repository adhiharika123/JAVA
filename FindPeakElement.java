/* A peak element in an array refers to the element that is greater than both of its neighbors. 
Basically, if arr[i] is the peak element, arr[i] > arr[i-1] and arr[i] > arr[i+1]. 

A peak element is one that is greater than its neighbours */

import java.util.Scanner;

public class FindPeakElement {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Peak Element is at index : " + findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n-2;
        //Edge cases
        //if(n == 0) return 0;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(nums[mid] > nums[mid-1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
