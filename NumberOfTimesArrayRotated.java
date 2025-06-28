import java.util.Scanner;

public class NumberOfTimesArrayRotated {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Number Of Times Array Rotated is : " +findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = nums[low];
        int index = -1;
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
                if(nums[low] < ans){
                    ans = nums[low];
                    index = low;
                }
                break;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] < ans){
                    ans = nums[low];
                    index = low;
                }
                low = mid + 1;
            }
            else{
                if(nums[mid] < ans){
                    ans = nums[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
