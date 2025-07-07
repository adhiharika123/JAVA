import java.util.Scanner;

public class RowsWithMaxOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        System.out.println("Enter m value:");
        int m = sc.nextInt();
        System.out.println("Enter matrix elements:");
        int mat[][] = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int result[] = rowAndMaximumOnes(mat);
        System.out.print("The Max Ones is at index : " + result[0] + " and their count : " + result[1]);
    }
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        //Approch - Brute Force 
        /*
        int rows = mat.length;
        int cols = mat[0].length;
        int cnt_max = 0;
        int index = 0;

        for(int i = 0 ; i < rows ; i++){
            int cnt_ones = 0;
            for(int j = 0 ; j < cols ; j++){
                cnt_ones += mat[i][j];
            }
            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return new int[] {index,cnt_max};
        */

        //Approch - Binary Search Algorithm
        return rowWithMaxOnes(mat);
    }
    public static int lowerBound(int[] rows, int x){
        //int rows = mat.length;
        //int cols = mat[0].length;
        int low = 0;
        int high = rows.length-1;
        int ans = rows.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(rows[mid] >= x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] rowWithMaxOnes(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int cnt_max = 0;
        int index = -1;

        for(int i = 0 ; i < rows ; i++){
            int cnt_ones = cols - lowerBound(mat[i],1);
            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return new int[] {index, cnt_max};       
    }
}
