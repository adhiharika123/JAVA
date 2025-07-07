import java.util.Scanner;

public class SearchIn2DMatrix {
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
        int rows = matrix.length;
        int cols = matrix[0].length;

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

        //Approch - Binary Search Algorithm
        for(int i = 0 ; i < rows ; i++){
            if(matrix[i][0] <= target && target <= matrix[i][cols-1]){
                return BinarySearch(matrix[i],target);
            }
        }
        return false;
    }
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
}
