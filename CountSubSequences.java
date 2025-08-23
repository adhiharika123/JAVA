import java.util.*;
public class CountSubSequences {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements : ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k value : ");
        int k = sc.nextInt();
        System.out.println("The Subsequences with given sum k is : " + countSubSequences(arr, n, 0, 0, k));
       
    }
    public static int countSubSequences(int arr[], int n, int index, int sumSoFar, int k){
        if(index == n){
            return sumSoFar == k ? 1 : 0;
        }
        //Include the current element
        int include = countSubSequences(arr, n, index + 1, sumSoFar + arr[index], k);

        //Exclude the current element
        int exclude = countSubSequences(arr, n, index + 1, sumSoFar, k);

        //Way To Sum All Valid Sequences From Both The Choices
        return include + exclude;
    }
    
}
