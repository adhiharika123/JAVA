import java.util.*;
public class MaximalRectangle{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows value : ");
        int n = sc.nextInt();
        System.out.println("Enter colums value : ");
        int m = sc.nextInt();
        System.out.println("Enter matrix elements : ");
        char[][] matrix = new char[n][m];
        for(int i = 0 ; i < n; i++){
            String row = sc.next();
            for(int j = 0; j < m ; j++){
                matrix[i][j] = row.charAt(j);
            }
        }
        int result = maximalRectangle(matrix);
        System.out.println("The Maximum Area of Rectangle containing only 1's is : " + result);
    }
    public static int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j]+=1;
                }
                else{
                    heights[j]=0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();

        //Find Next Smaller Element to left
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        //Find Next Smaller Element to right
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        //Calculate Max Area
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}