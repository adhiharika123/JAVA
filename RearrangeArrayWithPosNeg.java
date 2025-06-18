import java.util.Scanner;

public class RearrangeArrayWithPosNeg {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Rearrange(arr, n);
    }
    public static void Rearrange(int arr[], int n){
        int pos_Cnt = 0 ;
        int neg_Cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0) 
                pos_Cnt++;
            else 
                neg_Cnt++;
        }
        int pos_arr[] = new int[pos_Cnt];
        int neg_arr[] = new int[neg_Cnt];
        int pos_ind = 0;
        int neg_ind = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0) 
                pos_arr[pos_ind++] = arr[i];
            else 
                neg_arr[neg_ind++] = arr[i];
        }
        System.out.print("Positive numbers :");
        for(int num : pos_arr){
            System.out.println(num + " ");
        }
        System.out.print("Negative numbers :");
        for(int num : neg_arr){
            System.out.println(num + " ");
        }
        int result[] = new int[n];  
        for(int i = 0 ; i < n/2; i++){
            result[2 * i] = pos_arr[i];
            result[2 * i + 1] = neg_arr[i];
        }

        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
