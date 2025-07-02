import java.util.*;
public class KthPosMissingNum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k value:");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Missing Number at Kth Position is  : " + findKthPositive(arr, k));
    }
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        //Using Linear Search
        /*
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
        */
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                //ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
                
            }
            
        }
        return low + k;
    }
}