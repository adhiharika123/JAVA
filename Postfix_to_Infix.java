import java.util.Scanner;
import java.util.Stack;

public class Postfix_to_Infix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression");
        String exp = sc.nextLine();
        System.out.println("Postfix expression : " + exp);
        System.out.println("Infix expression is : " + postfixToInfix(exp));
    }
    public static String postfixToInfix(String exp){
        String result = new String("");
        Stack <String> stack = new Stack<>();
        int l = exp.length();
        for(int i = 0; i < l; i++){
            char c = exp.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op2 + c + op1 + ")";
                stack.push(temp);
            }
            else{
                stack.push(c + "");
            }
        }
        return stack.pop();
    }
    public static boolean isOperator(char c){
        switch(c){
            case '+' :
            case '-' :
            case '*' :
            case '/' :
            case '^' :
            case '%' :
                return true;
        }
        return false;
    }
}
