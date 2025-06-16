import java.util.*;

public class Sortanarrayof0s1sand2s {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sortarray(arr, n);
    }

   /*  public static void sortarray(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    */

    public static void sortarray(int arr[], int n){
        int count1=0,count2=0,count3=0;
        for(int num : arr){
            if (num == 0) count1++;
            else if (num == 1) count2++;
            else count3++;
        }
        int index = 0;
        for(int i = 0 ; i < count1 ; i++){
            arr[index] = 0;
            index++;
        }
        for(int i = 0 ; i < count2 ; i++){
            arr[index] = 1;
            index++;
        }
        for(int i = 0 ; i < count3; i++){
            arr[index] = 2;
            index++;
        }
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
