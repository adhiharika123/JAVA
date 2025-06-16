import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Max Count is : " + ConsecutiveOnes(arr,n));
    }
    public static int ConsecutiveOnes(int arr[], int n){
        int count = 0;
        int max_count = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 1){
                count++;
            }
            else{
                max_count = Math.max(max_count,count);
                count = 0;
            }
        }
        return Math.max(max_count, count);
    }
}
