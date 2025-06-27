import java.util.*;
import java.util.Scanner;
public class FirstAndLastOccurance {
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
        int result[]=searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int First = first(nums, target);
        int Last = last(nums, target);
        return new int[] { First, Last};
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
