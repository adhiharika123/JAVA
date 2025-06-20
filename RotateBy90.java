import java.util.*;
public class RotateBy90{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows :");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns :");
        int cols = sc.nextInt();
        System.out.println("Enter matrix Elements :");
        int arr[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        if(rows==cols){
            System.out.println("Transposing Square matrix:");
            RotateInplace(arr);
            MatrixReverse(arr);
        }
        else{
            System.out.println("Transposing Non - Square matrix:");
            Rotate(arr);
            MatrixReverse(arr);
        }
    }
    public static void RotateInplace(int arr[][]){
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i = 0 ; i < rows ; i++){
            for(int j = i+1 ; j < cols ; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] Rotate(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] transpose = new int[cols][rows];

        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        return transpose;
    }
    public static void MatrixReverse(int arr[][]){
        int rows = arr.length;
        int cols=  arr[0].length;
        for(int j = 0 ; j < cols ; j++){
            int top = 0 ;
            int bottom = rows - 1;
            while(top < bottom){
                int temp = arr[top][j];
                arr[top][j] = arr[bottom][j];
                arr[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
        System.out.println("The 90 Degree Matrix is : ");
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    /*
     * 
     *  //Rotate 90 degree clockwise
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }

     */
}