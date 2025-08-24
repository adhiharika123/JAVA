/* Find all valid combinations of k numbers that sum upto n,
such that the following conditions are true: 
    -> Only numbers 1 through 9 are used
    -> Each number is used atmost once
*/

import java.util.*;
public class CombinationSumIII {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        List<List<Integer>> array = combinationSum3(k, n);
        System.out.println("The Combinations are : ");
        for(List<Integer> arr : array){
            System.out.print(arr + " ");
        }
        System.out.println();
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<> ();
        findCombinations(1,k,n, new ArrayList<>(), ans);
        return ans;
    }
    public static void findCombinations(int start, int k , int n, List<Integer> comb, List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<> (comb));
            return;
        }
        for(int i = start; i <= 9; i++){
            comb.add(i);    //Choose
            findCombinations(i+1, k-1, n-i, comb, ans);     //Recursive pick
            comb.remove(comb.size() - 1);   //Undo (Backtrack)
        }
    }
}
