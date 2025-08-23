import java.util.*;
public class GenerateParenthesis {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N value : ");
        int N = sc.nextInt();
        System.out.println("The Parenthesis Generated are : ");
        generate("",0,0,N);
    }
    
    public static void generate(String str, int open, int close, int n){
        //Base Condition => Since In Paranthesis the number of "(" equals to number of ")" i.e., 2*n
        if(str.length() == 2*n){
            System.out.print(str + " ");
            return;
        }
        //we can add "(" if open < n
        if(open < n){
            generate(str + "(" , open+1, close , n);
        }
        //we can add ")" if close < open 
        if(close < open){
            generate(str + ")", open,close+1, n);
        }

    }
}
