import java.util.*;
public class MinimiseMaximumDistancebetweenGasStations {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n(Array Element size) value");
        int n = sc.nextInt();
        System.out.println("Enter k(gasStations value:)");
        int k = sc.nextInt();        
        System.out.println("Enter array elements:");
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("The Minimise Maximum Distance Between Gas Stations is : " + minimiseMaxDistance(arr, k));
    }
    /* 

    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        int howMany[] = new int[n-1];
        //Pick and Place gas Stations
        for(int gasStations = 1 ; gasStations <= k ; gasStations++){
            double maxSection = -1;
            int maxIndex = -1;
            //fond the max section and insert the gas station
            for(int i = 0 ; i < n-1 ; i++){
                double diff = stations[i+1] - stations[i];
                double section_length = diff/(howMany[i]+1);
                if(section_length > maxSection){
                    maxSection = section_length;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }
        double maxAns= -1;
        for(int i = 0 ; i < n-1 ; i++){
            double diff = stations[i+1] - stations[i];
            double section_length = diff / (double)(howMany[i] + 1);
            maxAns = Math.max(maxAns, section_length);
        }
        return maxAns;
        
    }
    */

    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
