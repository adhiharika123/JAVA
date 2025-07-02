import java.util.Scanner;

public class MinNoOfDaysForMBouquet {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m(Number Of Bouquets) value:");
        int m = sc.nextInt();
        System.out.println("Enter k(Number of Adjacent Flowers) value:");
        int k = sc.nextInt();
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int bloomDay[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            bloomDay[i] = sc.nextInt();
        }
        System.out.print("The Minimum Number Of Days To make M bouquets : " + minDays(bloomDay, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        long v = m * k;
        int n = bloomDay.length;
        if(v > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;


        for(int num : bloomDay){
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        //Using Linear Search
        /*
        for(int i = low ; i <= high ; i++){
            if(possible(bloomDay, i, m, k)){
                return i;
            }
        }
        return -1;
        */
        
        //Using Binary Search
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(possible(bloomDay, mid, m , k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans; 
    }

    public static boolean possible(int[] arr, int day, int m, int k){
        int n = arr.length;
        int cnt = 0;
        int noB = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                cnt += 1;
            }
            else{
                noB += (cnt/k);
                cnt = 0;
            }
        }
        noB += (cnt/k);
        return noB >= m;
    }
}

