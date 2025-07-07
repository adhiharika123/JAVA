import java.util.Scanner;

public class FindPeakElementII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows value:");
        int rows = sc.nextInt();
        System.out.println("Enter cols value:");
        int cols = sc.nextInt();
        System.out.println("Enter matrix elements:");
        int mat[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int result[] = findPeakGrid(mat);
        System.out.println("Peak found at: (" + result[0] + ", " + result[1] + ")");
    }
    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0;
        int right = cols - 1;

        while(left <= right){
            int midCol = left + (right - left) / 2;
            int maxRow = 0;
            for(int i = 1 ; i < rows ; i++){
                if(mat[i][midCol] > mat[maxRow][midCol]){
                    maxRow = i;
                }
            }

            int current = mat[maxRow][midCol];
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightVal = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;

            if(current > leftVal && current > rightVal){
                return new int[] {maxRow, midCol};
            }
            else if(leftVal > current){
                right = midCol - 1;
            }
            else{
                left = midCol + 1;
            }
        }
        return new int[] {-1,-1};
    }
}
