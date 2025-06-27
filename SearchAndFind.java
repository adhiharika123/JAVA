import java.util.*;
public class SearchAndFind{
    public static void main(String args[]){
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
        System.out.print("The target value is at index : " + searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;        
        int ans = n;
        /*
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    */

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == mid){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}

    
