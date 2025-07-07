import java.util.Scanner;

public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows value:");
        int rows = sc.nextInt();
        System.out.println("Enter cols value:");
        int cols = sc.nextInt();
        System.out.println("Enter target value:");
        int target = sc.nextInt();
        System.out.println("Enter matrix elements:");
        int matrix[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }       
        boolean found = searchMatrix(matrix, target);
        System.out.println(found);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        //Approch - Brute Force 
        /*
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }            
        }
        return false;
        */

        //Optimal Approch - Using Staircase method
        //Method 1
        /*
        int row = 0;
        int col = m-1;
        while(row < n && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
        */
        //Method 2

        int row = n-1;
        int col = 0;
        while(row >= 0 && col < m){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                row--;
            }
            else{
                col++;
            }
        }
        return false;

        /*
        for(int i = 0 ; i < rows ; i++){
            if(matrix[i][0] <= target && target <= matrix[i][cols-1]){
                if(BinarySearch(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
        */
    }

    //Approch - Using Binary Search
    /*
    public static boolean BinarySearch(int[] rows , int target){
        //int rows = matrix.length;
        int low = 0 ;
        int high = rows.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(rows[mid] == target){
                return true;
            }
            else if(rows[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    */
}
