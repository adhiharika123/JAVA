import java.util.*;
public class MergeIntervals{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int intervals[][] = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int result[][] = Merge(intervals);
        System.out.println("Merge Intervals are :");
        for(int[] interval : result){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
    public static int[][] Merge(int intervals[][]){
        //Sort array based on starting indexes
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        //To store Result
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            //Add interval if not overlap 
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }
            //Merge intervals if they overlap
            else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }
        int result[][] = new int[merged.size()][2];
        for(int i = 0 ; i < merged.size() ; i++){
            result[i] = merged.get(i);
        }
        return result;
    }
}