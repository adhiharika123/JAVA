import java.util.*;
public class TwoSum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter target value:");
        int target = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int result[] = TwoSum(arr, n, target);
        System.out.print("There exists a sum with two elements at indices:"+ Arrays.toString(result));
    }
    public static int[] TwoSum(int arr[], int n, int target){
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                sum = arr[i]+arr[j];
                if(sum == target){
                    return new int[] {i,j};
                    
                }
                
            }
        }
        return new int[] {};
    }
}