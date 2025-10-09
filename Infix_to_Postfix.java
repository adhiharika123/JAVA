import java.util.*;
public class Infix_to_Postfix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the expression : ");
        String exp = sc.nextLine();
        System.out.println("Infix expression is : " + exp);
        System.out.println("Prefix expression is " + infixToPostfix(exp));
        sc.close();
    }

    public static String infixToPostfix(String exp){
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
        
            //If operand move to result
            if(Character.isLetterOrDigit(c)){
                result += c;
            }
            //If '(' push to stack
            else if(c == '('){
                stack.push(c);
            }
            //If ')' pop until '(' is found
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result += stack.pop();
                }
                stack.pop();
            }
            //If Operator check for precedence
            else{
                while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        //Pop all from stack
        while(!stack.isEmpty()){
            if(stack.peek() == '('){
                return " Invalid Character..";
            }
            result += stack.pop();
        }
        return result;
    }

    //Used to return the precedence of a given operator ; Higher number means Higher precedence 
    public static int Prec(char ch){
        switch(ch){
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