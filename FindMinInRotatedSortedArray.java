import java.util.Scanner;

public class FindMinInRotatedSortedArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Minimum Element in Rotated Sorted Array is : " +findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = nums[low];
        /*
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low++;
            }
            if(nums[mid] < nums[high]){
                ans = Math.min(ans, nums[high]);
                high--;
            }
        } 
        return ans;
        */
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
