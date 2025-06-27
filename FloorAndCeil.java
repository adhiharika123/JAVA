import java.util.*;
public class FloorAndCeil {
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
        int floorVal = floor(nums, target);
        int ceilVal = ceil(nums, target);

        System.out.print("The Floor and Ceil elements are: ");
        if (floorVal == -1) System.out.print("Floor: None, ");
        else System.out.print("Floor: " + floorVal + ", ");

        if (ceilVal == -1) System.out.print("Ceil: None");
        else System.out.print("Ceil: " + ceilVal);
    }
    public static int floor(int nums[], int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //int mid = (low+high)/2;
        int ans = -1;
               
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] <= target) {
                ans = nums[mid];
                low = mid+1;  
            }
            else {              
                high = mid -1;
                
            }
        }
        return ans;
    }
    public static int ceil(int nums[], int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //int mid = (low+high)/2;
        int ans = -1;
               
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] >= target) {
                ans = nums[mid];
                high = mid -1; 
            }
            else {       
                low = mid+1;       
            }
        }
        return ans;
    }
}
