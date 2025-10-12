import java.util.*;
public class BinarySum { 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter goal value : ");
        int goal = sc.nextInt();
        int result = numSubarraysWithSum(nums, goal);
        System.out.println("The maximum fruits it can be fit in given baskets are : " + result);
    }
    //  Brute Force
    /*
    public static int numSubarraysWithSum(int[] nums, int goal) {       
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == goal){
                    count++;
                }
            }
        }
        return count;        
    }
    */

    //  Optimal Approach
    public static int numSubarraysWithSum(int[] nums, int goal){
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }
    public static int atmost(int nums[], int goal){
        if(goal < 0) return 0;
        int left = 0;
        int sum = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}