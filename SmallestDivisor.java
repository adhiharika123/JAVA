import java.util.*;

public class SmallestDivisor{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter limit value:");
        int limit = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Smallest Divisor is : " + smallestDivisor(nums, limit));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        
        int n = nums.length;
        int maxi = findMax(nums);
        int low = 1;
        int high = maxi;

        while(low <= high){
            int mid = (low + high)/2;
            int total_sum = CountSpeed(nums, mid);
            if(total_sum <= threshold){
                high = mid - 1; // try to find smaller valid speed
            }
            else{
                low = mid + 1; // speed too slow, need to go faster
            }
        }
        return low;

    }
    public static int findMax(int nums[]){
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }
    public static int CountSpeed(int nums[], int sum){
        int total_sum = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            total_sum += Math.ceil((double) nums[i] / (double) sum);
        }
        return total_sum;
    }
}