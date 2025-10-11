/*
A celebrity is a person who is known to all but does not know anyone at a party. 
A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party 
such that if an element of row i and column j is set to 1 it means ith person knows jth person. 
You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
 */
import java.util.*;

public class CelebrityProblem{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns : ");
        int m = sc.nextInt();
        System.out.println("Enter matrix elements : ");
        int mat[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt(); 
            }
        }
        /* 
        int[][] M = {
            {0, 1, 1, 0}, 
            {0, 0, 0, 0}, 
            {1, 1, 0, 0}, 
            {0, 1, 1, 0}
        }; 
        */       
        // Call the function to find the index of the celebrity
        int ans = celebrity(mat);
        
        // Print the result
        System.out.println("The index of the celebrity is: " + ans);
    }
    /*
    public static int celebrity(int mat[][]) {
        int n = mat.length;
        // code here
        Stack<Integer> st = new Stack<>();
        //Push all to stack first
        for(int i = 0; i < n; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();
            if(mat[a][b] == 1){
                st.push(b);
            }
            else{
                st.push(a);
            }
        }
        int candidate = st.pop();
        //Verify Candidate is Celebrity or not
        for(int i = 0; i < n; i++){
            if(i != candidate){
                if(mat[candidate][i] == 1 || mat[i][candidate] == 0){
                    return -1;
                }
            }
        }
        return candidate;
    }
    */
    
    public static int celebrity(int mat[][]){
        int n = mat.length;
        int i = 0;
        int j = n-1;
        while(i < j){
            if(mat[i][j] == 1){
                i++;
            }
            else{
                j--;
            }
        }
        int candidate = i;
        for(int k = 0; k < n; k++){
            if(k != candidate && (mat[candidate][k] == 1 || mat[k][candidate] == 0)){
                return -1;
            }
        }
        return candidate;
    }
}