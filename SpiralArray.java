import java.util.*;
public class SpiralArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows :");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns :");
        int cols = sc.nextInt();
        System.out.println("Enter matrix Elements :");
        int matrix[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("The Spiral Array Elements are : " + spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> s=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;
        while(top <= bottom && left <= right){
            //left to right
            for(int i=left;i<=right;i++){
                s.add(matrix[top][i]);
            }
            top++;

            //top to bottom
            for(int i=top;i<=bottom;i++){
                s.add(matrix[i][right]);
            }
            right--;

            //right to left
            if(top <= bottom){
                for(int i=right;i>=left;i--){
                    s.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //bottom to top
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    s.add(matrix[i][left]);
                }
                left++;
            }
            
        }
        return s;
    }
}
