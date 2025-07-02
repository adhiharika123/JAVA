import java.util.*;

public class AggressiveCows {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k(cows) value:");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int stalls[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            stalls[i] = sc.nextInt();
        }
        System.out.print("The Maximum minimum distance possible is : " + aggressiveCows(stalls, k));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int limit = stalls[n-1] - stalls[0];

        //Using linear Search
        /*
        for(int i = 0 ; i <= limit ; i++){
            if(canWePlace(stalls, i, k) == false){
                return (i-1);
            }
        }
        return limit;
        */

        //Using binary Search
        int low = 1;
        int high = limit;
        while(low <= high){
            int mid = (low + high) / 2;
            if(canWePlace(stalls, mid, k) == true){
                low = mid + 1;  //Try bigger ones
            }
            else{
                high = mid - 1; //Try smaller ones
            }
        }
        return high;
    }
    public static boolean canWePlace(int[] stalls, int dist, int cows){
        int n = stalls.length;
        int cowsCnt = 1;
        int last = stalls[0];
        for(int i = 0 ; i < n ; i++){
            if(stalls[i] - last >= dist){
                cowsCnt += 1;
                last = stalls[i];
            }
            if(cowsCnt >= cows){
                return true;
            }
        }
        return false;
    }
}

