import java.util.*;
public class BinarySearch{
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
        System.out.print("The target value is at index : " + search(nums, target));
    }
    public static int search(int[] nums, int target) {
        //Iterative Approch
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = (low+high)/2;
        /*       
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
        */

        //Recursive Approach
        return BinarySearch(nums, low, high, target);
    }
    public static int BinarySearch(int nums[], int low, int high, int target){
        if(low > high) return -1;
        int mid = (low+high)/2;
        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) return BinarySearch(nums, mid+1, high, target);
        else return BinarySearch(nums, low, mid-1, target);
    }
}