import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("The Array elements are : ");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = subsets(arr);
        System.out.println("All Subsets are : ");
        for(List<Integer> subset : ans){
            System.out.print(subset + " ");
        } 
    }
    /*
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int num = 0 ; num < (1 << n) ; num++){
            List<Integer> subset = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                // If bit is 1 set 
                if((num & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    */

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int index, int nums[], List<Integer> current, List<List<Integer>> result){
        // Add the current subset to result
        result.add(new ArrayList<>(current));

        for(int i = index ; i < nums.length ; i++){
            // Choose nums[i]
            current.add(nums[i]);
            // Move to the Next Index
            backtrack(i+1, nums, current, result);
            // Undo the choice(backtrack)
            current.remove(current.size() - 1);
        }
    }
}
