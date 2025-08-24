import java.util.*;
public class SubsetSum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int N = sc.nextInt();
        System.out.println("The Array elements are : ");
        int arr[] = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = subsets(arr, N);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }          
    }
    public static ArrayList<Integer> subsets(int[] arr, int N){
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumHelper(0, 0, arr, N, result);
        Collections.sort(result);
        return result;
    }
    public static void subsetSumHelper(int index, int sum, int[] arr, int N, ArrayList<Integer> result){
        if(index == N){
            result.add(sum);
            return;
        }
        subsetSumHelper(index+1, sum+arr[index], arr, N, result);   //Pick an Element
        subsetSumHelper(index+1, sum, arr, N, result);  //Not Pick an Element
    }
}
