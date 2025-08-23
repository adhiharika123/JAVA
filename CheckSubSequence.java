import java.util.*;
public class CheckSubSequence {
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
        if(countSubSequences(arr, n, 0, 0, k)){
            System.out.println("Yes there exists a SubSequence with given sum k");
        }
        else{
            System.out.println("No there exists a SubSequence with given sum k");
        }
       
    }
    public static boolean countSubSequences(int arr[], int n, int index, int sumSoFar, int k){
        if(sumSoFar == k){
            return true;
        }
        if(index == n){
            return false;
        }
        //Include the current element
        if(countSubSequences(arr, n, index + 1, sumSoFar + arr[index], k)){
            return true;
        }

        //Exclude the current element
        return countSubSequences(arr, n, index + 1, sumSoFar, k);
    }
    
}
