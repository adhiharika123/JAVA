import java.util.*;

public class Infix_to_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression : ");
        String exp = sc.nextLine();
        System.out.println("Infix expression is : " + exp);
        System.out.println("Prefix Expression is : " + infixToPrefix(exp));
    }
    public static String infixToPrefix(String exp) {
        StringBuilder input = new StringBuilder(exp);
        input.reverse();

        //Replace '(' with ')' and vice versa
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                input.setCharAt(i, ')');
            } else if (input.charAt(i) == ')') {
                input.setCharAt(i, '(');
            }
        }

        String postfix = infixToPostfix(input.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
            } 
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty()) stack.pop();
            } 
            else { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
