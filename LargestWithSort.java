import java.util.*;
public class LargestWithSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The largest element is :" +LargestElement(arr));
    }
    /* public static int LargestElement(int arr[]){
      for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j < arr.length-i-1 ; j++){
                    int temp;
                    if(arr[j] > arr[j+1]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            }
        }
        return arr[arr.length-1];
    } */
    public static int LargestElement(int arr[]){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }


}
