import java.util.Scanner;

public class LongestSubArrayWithPosNeg {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter k value:");
        int k = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The longest sub array length is :" + Subarray(arr,n ,k));
    }
    public static int Subarray(int arr[], int n , int k){
        int len = 0;
        for(int i = 0 ; i < n ; i++){
            long sum = 0;
            for(int j = i ; j < n ; j++){
                sum += arr[j];

                if(sum == k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len; 
        
    }
}
