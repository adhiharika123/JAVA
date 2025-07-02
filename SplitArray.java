import java.util.Scanner;

public class SplitArray {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k(Length of subarray) value:");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Number of Pages is : " + findPages(nums, k));
    }

    public static int findPages(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            min = Math.max(min, nums[i]);
            sum += nums[i];
        }
         
        //Using Linear Search
        /*
        for(int max_sum = min ; max_sum <= sum ; max_sum++){
            if(LargestSum(nums, max_sum) == k){
                return max_sum;
            }
        }
        return -1;
        */

        //Using Binary Search
        int low = min;
        int high = sum;

        while(low <= high){
            int mid = (low+high)/2;
            int subarray = LargestSum(nums, mid);
            if(subarray > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int LargestSum(int nums[], int max_sum){
        int n = nums.length;
        int cnt = 1;
        int max_subarray_sum = 0;

        for(int i = 0 ; i < n ; i++){
            if(max_subarray_sum + nums[i] <= max_sum){
                max_subarray_sum += nums[i];
            }
            else{
                cnt++;
                max_subarray_sum = nums[i];
            }
        }
        return cnt;
    }
}
