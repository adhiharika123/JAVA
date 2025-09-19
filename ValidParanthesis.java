import java.util.*;
public class ValidParanthesis {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        System.out.println("Enter the String value : ");
        String s = sc.next();
        boolean result = isValid(s);
        System.out.println("The String has valid paranthesis : " + result);
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char it : s.toCharArray()){
            if(it == '(' || it == '{' || it == '['){
                st.push(it);
            }
            else{
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') || (it == '}' && ch == '{') || (it == ']' && ch == '[')){
                    continue;
                }
                else{
                    return false;
                }
            } 
        }
        return st.isEmpty();
    }
}
