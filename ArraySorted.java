import java.util.*;
class ArraySorted{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        boolean result = IsSorted(arr,n);
        System.out.println(result);
    }
    /*public static boolean IsSorted(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length - 1 ; j++){
                if(arr[j]<arr[j+1]){
                    return false;
                }
            }
        }
        return true;
    } */
    public static boolean IsSorted(int arr[], int n){
        for(int i = 1 ; i < arr.length ; i++){
                if(arr[i]<arr[i-1]){
                    return false;
                }
        }
        return true;
    }
}