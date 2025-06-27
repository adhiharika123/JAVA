/* The upper bound algorithm finds the first or the smallest index in a sorted array,
where the value at that index is greater than the given key i.e. x.
The upper bound is the smallest index, ind, where arr[ind] > x. */

import java.util.Scanner;

public class UpperBound {
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
        System.out.print("The target value is at index : " + upper(nums, target));
    }
    //Approch 1 : Linear Search TC:O(N)
    /* 
    public static int upper(int nums[], int target){
        int n = nums.length;
        for(int i = 0 ; i <= n ; i++){
            if(nums[i] > target){
                return i;
            }
        }
        return -1;
    }
    */

    public static int upper(int nums[], int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //int mid = (low+high)/2;
        int ans = -1; 
               
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] > target) {
                ans = mid;
                high = mid -1;
            }
            else low = mid+1;
        }
        return ans;
        

        //Recursive Approach
        //return UpperBound(nums, low, high, target);
    }
    /* 
    public static int UpperBound(int nums[], int low, int high, int target){
        if(low > high) return -1;
        int mid = (low+high)/2;
        if (nums[mid] > target) {
            int leftResult = UpperBound(nums, low, mid - 1, target);
            return (leftResult != -1) ? leftResult : mid;
        }
        else return UpperBound(nums, mid+1, high, target);
    }
    */
}

