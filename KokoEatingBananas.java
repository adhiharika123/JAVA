import java.util.*;

public class KokoEatingBananas{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter h value:");
        int h = sc.nextInt();
        System.out.println("Enter array elements:");
        int nums[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        System.out.print("The Smallest speed (Number of bananas / hour) is : " + minEatingSpeed(nums, h));
    }
    
    public static int minEatingSpeed(int[] piles, int h) {
        //Approach 1 :Using Linear Search TC : O(N)
        
        /*
        int n = piles.length;
        int maxi = findMax(piles); //Find max element

        //Count Minimum Spped(Number of bananas eaten by koko per hour)
        //speed = distance/ time
        for(int i = 1 ; i <= maxi ; i++){
            int req_time = CountSpeed(piles, i);
            if(req_time <= h){
                return i;
            }
        }
        return maxi;
        */
        int n = piles.length;
        int maxi = findMax(piles);
        int low = 1;
        int high = maxi;

        while(low <= high){
            int mid = (low + high)/2;
            int total_hr = CountSpeed(piles, mid);
            if(total_hr <= h){
                high = mid - 1; // try to find smaller valid speed
            }
            else{
                low = mid + 1; // speed too slow, need to go faster
            }
        }
        return low;

    }
    public static int findMax(int piles[]){
        int maxi = Integer.MIN_VALUE;
        int n = piles.length;

        for(int i = 0 ; i < n ; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }
    public static int CountSpeed(int piles[], int hourly){
        int total_hr = 0;
        int n = piles.length;

        for(int i = 0 ; i < n ; i++){
            total_hr += Math.ceil((double) piles[i] / (double) hourly);
        }
        return total_hr;
    }
}