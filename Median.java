import java.util.*;
public class Median{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter m value : ");
        int m = sc.nextInt();
        System.out.println("Enter matrix elements:");
        int[][] mat = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("The matrix median is :" + median(mat, n, m));
    }
    public static int median(int[][] mat, int n, int m){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0 ; i < m ; i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][n-1]);
        }
        int req = (n*m)/2;
        while(low <= high){
            int mid = (low + high) /2;
            int smallEqual = countSmallEqual(mat, n, m, mid);
            if(smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public static int countSmallEqual(int[][] mat, int n , int m, int x){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += upperBound(mat[i], x, m);
        }
        return cnt;
    }
    public static int upperBound(int[] arr, int x, int n){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > x){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}