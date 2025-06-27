import java.util.*;

public class CountOccurances {
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
        //System.out.println("The Count Occurances are :" + Count(nums, target));
        System.out.println("The Count Occurances are :" + searchRange(nums, target));
    }
    //Approch 1 : Linear Search TC : O(N)
    /* 
    public static int Count(int nums[], int target){
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == target){
                count++;
            }
        }
        return count;
    }
    */

    //Approch 2 : Using Binary Search ((Last Occurance - First Occurance)+1) TC:O(NLOGN)
    public static int searchRange(int[] nums, int target) {
        int First = first(nums, target);
        int Last = last(nums, target);
        if (First == -1) return 0;
        return (Last - First)+ 1;
    }
    public static int first(int nums[], int target){
        int n = nums.length;
        int low = 0 ; 
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int last(int nums[], int target){
        int n = nums.length;
        int low = 0 ; 
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;                
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
