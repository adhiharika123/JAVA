import java.util.*;
public class CombinationSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int candidates[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            candidates[i] = sc.nextInt();
        }
        System.out.println("Enter target value : ");
        int target = sc.nextInt();
        List<List<Integer>> array = combinationSum(candidates, target);
        System.out.println("The Combinations are : ");
        for(List<Integer> arr : array){
            System.out.print(arr + " ");
        }
        System.out.println();
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<> ());
        return ans;
    }
    public static void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<> (ds));
            }
            return ;
        }
        if(candidates[index] <= target){
            ds.add(candidates[index]);
            findCombinations(index, candidates, target - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(index+1, candidates, target, ans, ds);
    }
}