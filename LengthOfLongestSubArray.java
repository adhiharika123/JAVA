import java.util.*;
public class LengthOfLongestSubArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("The Longest SubSequence of given array is : " + SubArray(arr, n));
    }
    /* 
    public static int SubArray(int arr[], int n){
        int len=0;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += arr[j];
            
                if(sum == 0){
                    len = Math.max(len,j-i+1);
                }
            }
        
        }
        return len;
    }
    */
    public static int SubArray(int arr[], int n){
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];

            if(sum == 0){
                max = i+1;
            }

            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return max ;
    }
}
