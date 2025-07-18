import java.util.Scanner;

public class MaximumNestingDepthOfParentheses {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String value: ");
        String s = sc.nextLine();
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s) {
        StringBuilder res = new StringBuilder();
        int depth_count = 0;
        int max_depth = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                depth_count++;
                max_depth = Math.max(max_depth, depth_count);
            }
            if(c == ')'){
                depth_count--;
            }
        }
        return max_depth;

    }
}
