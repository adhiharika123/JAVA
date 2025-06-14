import java.util.*;
public class Largest{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();        
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        LargestElement(arr);

    }
    public static void LargestElement(int arr[]){
        int max = arr[0];
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("The Largest Element is:" + max);
    }
}