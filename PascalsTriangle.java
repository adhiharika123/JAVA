
// Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

//Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

//Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle


import java.util.*;
public class PascalsTriangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numRows value:");
        int n = sc.nextInt();
        List<List<Integer>> triangle=Pascal(n); 
        
        for(List<Integer> i : triangle){
            for(int val : i){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        Variation1(n,triangle);
        Variation2(n,triangle);
    }

    //Variation 3
    public static List<List<Integer>> Pascal(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<>();
            int c=1;
            for(int j=1;j<=i;j++){
                row.add(c); 
                c=c*(i-j)/j; //Binomial Coefficient Formula
            }
            triangle.add(row);
        }
        return triangle;
    }

    //Variation1
    public static void Variation1(int numRows , List<List<Integer>> triangle){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row value :");
        int row = sc.nextInt();
        System.out.println("Enter col value :");
        int col = sc.nextInt();
        int rowIndex = row-1;
        int colIndex = col-1;
        if(rowIndex < numRows && colIndex <=row){
            System.out.println("The Required Element is : " + triangle.get(rowIndex).get(colIndex));
        }
        else{
            System.out.println("Invalid");
        }
        
    }
    
    //Variation2
    public static void Variation2(int numRows, List<List<Integer>> triangle){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row value");
        int row = sc.nextInt();
        int rowIndex = row-1;
        if(rowIndex < numRows){
            System.out.println(triangle.get(rowIndex));
        }
    }
}