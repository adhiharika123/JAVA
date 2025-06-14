//Right Rotate an Array By K moves or Right Rotate an Array By D positions.
import java.util.*;

public class RightRotateArrayByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter k value for rotate:");
        int k = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Rotate(arr,n,k);
    }
    public static void Rotate(int arr[], int n , int k){
        int temp[] = new int[k];
        for(int i = n - k ; i < n ; i++){
            temp[i-n+k] = arr[i];
        }
        for(int i = n - k - 1 ; i >= 0  ; i--){
            arr[i+k] = arr[i];
        }
        for(int i = 0 ; i < k ; i++){
            arr[i] = temp[i];
        }
        System.out.println("The Array Elements are :");
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
