//Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.
//Right Element is always a leader - > No elements to the right → ✅ Always a leader
import java.util.*;
public class LeaderInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i]=sc.nextInt();
        }
        ArrayList<Integer> arr = Leader(nums, n);
        Collections.sort(arr,Collections.reverseOrder());
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
    /*
    public static void Leader(int nums[], int n){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            boolean leader = true;
            for(int j = i+1 ; j < n ; j++){
                if(nums[j] > nums[i]){
                    leader = false;
                    break;
                }
            }
            if(leader){
                arr.add(nums[i]);
            }
        }
        for(int val : arr){
            System.out.print(val + " ");
        }
    } 
    */
    public static ArrayList<Integer> Leader(int nums[], int n){
        ArrayList<Integer> arr = new ArrayList<>();
        int max = nums[n-1];
        arr.add(nums[n-1]);
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] > max){
                arr.add(nums[i]);
                max=nums[i];
            }
        }
        return arr;
    }
    
        
}
