import java.util.Scanner;

public class PaintersPartition {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k(painters value:)");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Minimun time required is : " + findtime(arr, k));
    }
    public static int  findtime(int arr[], int k){
        int n = arr.length;
        int min = Integer.MIN_VALUE;
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        //Using Linear Search
        for(int i = min ; i <= max ; i++){
            if(countTime(arr, i) == k){
                return i;
            }
        }
        return -1;
    }
    public static int countTime(int arr[], int time){
        int n = arr.length;
        int painters = 1;
        int boardsPainters= 0;
        for(int i = 0 ; i < n ; i++){
            if(boardsPainters + arr[i] <= time){
                boardsPainters += arr[i];
            }
            else{
                painters++;
                boardsPainters = arr[i];
            }
        }
        return painters;
    }
}
