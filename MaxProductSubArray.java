import java.util.*;
public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The product of the largest subarray is :" + MaxProduct(arr,n));
    }
    //Approch 1 : Using BruteForce TC:O(N)^2
    /* 
    public static int MaxProduct(int arr[], int n){
        int max_prod = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int prod = 1;
            for(int j = i ; j < n; j++){
                prod *= arr[j];
                max_prod = Math.max(prod, max_prod);
            }
        }
        return max_prod;
    }
    */

    //Approch 2 : Using Kadane's Algorithm TC:O(N)
    public static int MaxProduct(int arr[], int n){
        int prod1 = arr[0], prod2 = arr[0] , result = arr[0];
        for(int i = 1 ; i < n ; i++){
            int temp = prod1;
            prod1 = Math.max(arr[i],Math.max(arr[i] * prod1, arr[i] * prod2));
            prod2 = Math.min(arr[i],Math.min(arr[i] * temp, arr[i] * prod2));
            result = Math.max(result, prod1);
        }
        return result;
    }
}
