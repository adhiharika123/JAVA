import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Majority Element in array is : " + Majority(arr,n));
    }
    public static int Majority(int arr[], int n){
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for( int j = 0 ; j < n ;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > n/2){
                return arr[i];
            }
        }
        return -1;
    }
}
