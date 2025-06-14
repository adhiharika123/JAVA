import java.util.*;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The unique elements:"+Duplicates2(arr));
    }
    public static int Duplicates2(int arr[]){
        int i = 0 ;
        for(int j = 0 ; j < arr.length ; j++){
            if(i < 2 || arr[i-2] != arr[j]){
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }
}

