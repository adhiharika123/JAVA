import java.util.*;
public class LinearSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter k value to search");
        int k = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The index of the searched element is "+ Search(arr, n, k));
    }
    public static int Search(int arr[], int n, int k){
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == k){
                return i ;
            }
        }
        return -1;
    }
}