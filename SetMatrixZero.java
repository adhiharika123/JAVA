import java.util.*;
public class SetMatrixZero{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row value:");
        int rows=sc.nextInt();
        System.out.print("Enter col value:");
        int cols=sc.nextInt();
        System.out.println("Enter array elements:");
        int arr[][] = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        MatrixZero(arr);
    }
    public static void MatrixZero(int arr[][]){
        int rows=arr.length;
        int cols=arr[0].length;
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(arr[i][j] == 0){
                    row[i]=true; // set row 
                    col[j]=true; //set col
                }
            }
        }
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(row[i] || col[j]){
                    arr[i][j]=0;
                }
            }
        }
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}