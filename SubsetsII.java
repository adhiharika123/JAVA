import java.util.*;

public class SubsetsII {
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
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<> ();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));

        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
