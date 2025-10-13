import java.util.*;

public class SubarraysWithKDistinctIntegers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        int result = subarraysWithKDistinct(nums, k);
        System.out.println("The Valid Subarrays with K Distinct integers are : " + result); 
    }
    //  Brute Force
    /*
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            Map<Integer, Integer> freq = new HashMap<>();
            for(int j = i; j < n; j++){
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                if(freq.size() ==  k){
                   count++;
                }
            }
        }
        return count;
    }
    */

    //  Optimal Approach
    public static int subarraysWithKDistinct(int[] nums, int k){
        return atmost(nums, k) - atmost(nums, k - 1);
    }
    private static int atmost(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        int left = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int right = 0; right < n; right++){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while(freq.size() > k){
                int l = nums[left];
                freq.put(l, freq.get(l) - 1);
                if(freq.get(l) == 0){
                    freq.remove(l);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
    
}
