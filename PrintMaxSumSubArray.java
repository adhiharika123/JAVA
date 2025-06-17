import java.util.Scanner;

public class PrintMaxSumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(Subarray(arr,n));
    }
    public static int Subarray(int arr[], int n){
        int current_sum = arr[0];
        int max_sum = arr[0];
        int start = 0 , end = 0 , temp_start = 0;
        for(int i = 1 ; i < n ; i++){
            current_sum = arr[i]+current_sum;
            if(arr[i] > current_sum){
                current_sum = arr[i];
                temp_start = i;
            }
            if(current_sum > max_sum){
                max_sum = current_sum;
                start = temp_start;
                end = i; 
            }
        }
        System.out.println("The Maximum Subarray is :");
        for(int i = start ; i <= end ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return max_sum;
        

    }
}
