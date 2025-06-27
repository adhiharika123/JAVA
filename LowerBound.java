/* The lower bound algorithm finds the first or the smallest index in a sorted array,
where the value at that index is greater than or equal to a given key i.e. x. */

import java.util.*;
public class LowerBound{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter target value: ");
        int target = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The target value is at index : " + Lower(nums, target));
    }
    public static int Lower(int[] nums, int target) {
        //Iterative Approch
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = (low+high)/2;
        int ans = n ;
        /*       
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= target) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            } 
            return ans;            
        }
        return -1;
        */

        //Recursive Approach
        return LowerBound(nums, low, high, target);
    }
    public static int LowerBound(int nums[], int low, int high, int target){
        if(low > high) return -1;
        int mid = (low+high)/2;
        if(nums[mid] >= target) return mid;
        else if(target > nums[mid]) return LowerBound(nums, mid+1, high, target);
        else return LowerBound(nums, low, mid-1, target);
    }
}