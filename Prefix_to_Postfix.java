import java.util.*;

public class Prefix_to_Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression : ");
        String exp = sc.nextLine();
        System.out.println("Prefix Expression is : " + exp);
        System.out.println("Postfix Expression is : " + prefixToPostfix(exp));
    }
    public static String prefixToPostfix(String exp){
        Stack <String> stack = new Stack<>();
        int l = exp.length();
        for(int i = l - 1; i >= 0; i--){
            char c = exp.charAt(i);
            if(isOperator(c)){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1 + op2 + c;
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
