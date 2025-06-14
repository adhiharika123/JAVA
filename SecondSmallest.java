import java.util.*;
class SecondSmallest{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The second smallest element is :"+SecondSmallest(arr));
    }
    public static int SecondSmallest(int arr[]){
        int small = Integer.MAX_VALUE;
        int second_small =  Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < small){
                second_small = small;
                small = arr[i];
            }
            else if(arr[i] < second_small && arr[i] != small){
                second_small = arr[i];
            }
        }
        return second_small;
    }
}