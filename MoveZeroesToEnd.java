import java.util.*;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        MoveZeroes(arr,n);
    }
    public static void MoveZeroes(int arr[], int n){
        int j = 0;
        int temp;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != 0){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println("The Array Elements Are :");
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i]+ " ");
        }
    } 
}
