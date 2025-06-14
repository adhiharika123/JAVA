import java.util.*;
public class RightRotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Rotate(arr);
    }
    public static void Rotate(int arr[]){
        int temp = arr[arr.length-1];
        for(int i = arr.length - 1 ; i > 0 ; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        System.out.println("The Array Elements are : " );
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
